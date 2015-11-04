// 
// Copyright 2011 Kuali Foundation, Inc. Licensed under the
// Educational Community License, Version 2.0 (the "License"); you may
// not use this file except in compliance with the License. You may
// obtain a copy of the License at
// 
// http://www.opensource.org/licenses/ecl2.php
// 
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an "AS IS"
// BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing
// permissions and limitations under the License.
// 
package org.kuali.continuity.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.kuali.continuity.domain.UIImageEnum;
import org.kuali.continuity.domain.UIImageTypeEnum;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ImageUploadDBMigration {
	
	// env
	enum EnvEnum {DEV, QA, STAGING, PROD;};

	// data source
	private DataSource dsKualiReady = null;
	private JdbcTemplate jdbcTemplateKRReady = null;
	
	// queries
	private final static String SELECT_SD_QUERY = "SELECT InstitutionID, Institution FROM SystemDomain WHERE CustomUrl = ?";
	private final static String DELETE_SD_QUERY = "DELETE FROM SystemDomainUIImage WHERE InstitutionID = ? AND Name = ?";
	
	// logger
	private static final Logger logger = Logger.getLogger(ImageUploadDBMigration.class);
	static {
		logger.setLevel(Level.DEBUG);
	}
	
	public ImageUploadDBMigration(String dbUrl, String dbUser, String dbPass) {
		this.dsKualiReady = new DriverManagerDataSource(
			"com.microsoft.sqlserver.jdbc.SQLServerDriver", 
			dbUrl, dbUser, dbPass);
		jdbcTemplateKRReady = new JdbcTemplate(this.dsKualiReady);
	}

	void upload(final Integer systemDomainId, final Map<UIImageEnum, Blob> imageMap) {
		// build column-value map
		Map<String, Object> colValueMap = new HashMap<String, Object>();
		
		Set<UIImageEnum> keys = imageMap.keySet();
		for (UIImageEnum key : keys) {
			// get blob
			Blob imgBlob = imageMap.get(key);
			if (imgBlob == null) continue;

			// set columns
			colValueMap.put("InstitutionID", systemDomainId);
			colValueMap.put("Name", key.name());
			colValueMap.put("UIImageType", UIImageTypeEnum.JPEG.name());
			colValueMap.put("UIImage", imgBlob);

			// delete first
			this.jdbcTemplateKRReady.update(
				DELETE_SD_QUERY,
			    new Object[] {systemDomainId, key.name()});
			
			// then insert new row
			SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(this.dsKualiReady);
			simpleInsert.setSchemaName("dbo");
			simpleInsert.setTableName("SystemDomainUIImage");
			simpleInsert.setColumnNames(new ArrayList<String>(colValueMap.keySet()));
			simpleInsert.execute(colValueMap);
		}

	}
	
	@SuppressWarnings("unchecked")
	Map<String, Object> getSystemDomain(String sdUrl) {
		try {
			return this.jdbcTemplateKRReady.queryForMap(SELECT_SD_QUERY, new Object[] {sdUrl});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public static void main (String[] args) {

		BufferedReader in = 
			new BufferedReader(new InputStreamReader(System.in));
		
		Integer systemDomainId = 0;
		String systemDomainName = "";
		EnvEnum envEnum = EnvEnum.DEV;
		int tsleep = 3000;
		
		
		try {
			// enter env
			do {
				System.out.print("Enter server environment (1 - Dev, 2 - QA, 3 - Staging, 4 - Production, 'X' to Exit): ");
				String env = in.readLine();
				if ("X".equalsIgnoreCase(env)) {
					System.out.println("Image upload aborted!");
					Thread.sleep(tsleep);
					return;
				}
				else if ("1".equals(env)) envEnum = EnvEnum.DEV;
				else if ("2".equals(env)) envEnum = EnvEnum.QA;
				else if ("3".equals(env)) envEnum = EnvEnum.STAGING;
				else if ("4".equals(env)) envEnum = EnvEnum.PROD;
				else continue;
				break;
			} while (true);
			
			// get properties file
			Properties props = new Properties();
	        URL url = ClassLoader.getSystemResource("dbimage.properties");
	        props.load(url.openStream());
			
	        // init
			ImageUploadDBMigration migration = new ImageUploadDBMigration(
				props.getProperty(envEnum.name() + ".url"),
				props.getProperty(envEnum.name() + ".username"),
				props.getProperty(envEnum.name() + ".password"));

			// enter institutions
			do {
				System.out.print("Enter institution's friendly url ('X' to Exit): ");
				String sdStr = in.readLine();
				if ("X".equalsIgnoreCase(sdStr)) {
					System.out.println("Image upload aborted!");
					Thread.sleep(tsleep);
					return;
				}
				Map<String, Object> sdMap = migration.getSystemDomain(sdStr);
				if (sdMap == null || sdMap.isEmpty()) {
					System.out.println("Not a valid institution, please try again.");
					continue;
				}
				System.out.println("You have selected '" + sdMap.get("Institution") + "'");
				System.out.print("Is this correct? (Y/N): ");
				String yn = in.readLine();
				if ("Y".equalsIgnoreCase(yn)) {
					systemDomainId = (Integer) sdMap.get("InstitutionID");
					systemDomainName = (String) sdMap.get("Institution");
					break;
				}
			} while (true);
			
			// get files
			Map<UIImageEnum, String> imageFiles = new HashMap<UIImageEnum, String>();
			imageFiles.put(UIImageEnum.BANNER, "web-kuali-banner.jpg");
			imageFiles.put(UIImageEnum.BANNER_TEXT, "web-kuali-banner-text.jpg");
			imageFiles.put(UIImageEnum.BEGIN, "web-kuali-begin.jpg");
			imageFiles.put(UIImageEnum.BEGIN_TEXT, "web-kuali-begin-text.jpg");
			Map<UIImageEnum, Blob> imageMap = new HashMap<UIImageEnum, Blob>();
			for (UIImageEnum uiImageEnum : UIImageEnum.values()) {
				String imageFileName = imageFiles.get(uiImageEnum);
				if (imageFileName == null || imageFileName.trim().length() == 0) continue;
				try {
					InputStream is =
						new FileInputStream("/kr-image-upload/" + imageFileName);
					if (is == null) continue;
					Blob b = Hibernate.createBlob(is);
					imageMap.put(uiImageEnum, b);
				} catch (FileNotFoundException e) {
					// ignore;
				}
			}

			if (imageMap == null || imageMap.isEmpty()) {
				System.out.println("No image found in the 'images' folder.  Image upload aborted!");
				Thread.sleep(tsleep);
				return;
			}
			
			// upload
			System.out.println("The following images are found:");
			for (UIImageEnum uiImageEnum : UIImageEnum.values()) {
				if (imageMap.containsKey(uiImageEnum))
					System.out.println("- " + imageFiles.get(uiImageEnum));
			}
			System.out.print("Upload these images to " + envEnum.name() + " for '" + systemDomainName + "'? (Y/N) ");

			String yn = in.readLine();
			if ("Y".equalsIgnoreCase(yn)) {
				migration.upload(systemDomainId, imageMap);
				System.out.println("Image upload successful!  Press any key to exit.");
				in.read();
			} else {
				System.out.println("Image upload aborted!");
				Thread.sleep(tsleep);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
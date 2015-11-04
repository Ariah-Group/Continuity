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
package org.kuali.continuity.plan.domain.ext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.kuali.continuity.plan.domain.OfficeEquipmentMinimum;

@Embeddable
@SuppressWarnings("serial")
public class OfficeEquipmentMinimums implements Serializable {

	// office equipment minimum requirements
	private Integer workstationMin;
	private Integer laptopMin;
	private Integer telephoneMin;
	private Integer printerMin;
	private Integer faxMin;
	private Integer copierMin;
	private Integer scannerMin;
	private Integer serverMin;
	private String workstationComment;
	private String laptopComment;
	private String telephoneComment;
	private String printerComment;
	private String faxComment;
	private String copierComment;
	private String scannerComment;
	private String serverComment;
	
	public OfficeEquipmentMinimums() {

	}
	
	@Column(name="key_workstation_min", insertable=false)
	public Integer getWorkstationMin() {
		return this.workstationMin;
	}

	public void setWorkstationMin(Integer workstationMin) {
		this.workstationMin = workstationMin;
	}

	@Column(name="key_laptop_min", insertable=false)
	public Integer getLaptopMin() {
		return this.laptopMin;
	}

	public void setLaptopMin(Integer laptopMin) {
		this.laptopMin = laptopMin;
	}

	@Column(name="key_telephone_min", insertable=false)
	public Integer getTelephoneMin() {
		return this.telephoneMin;
	}

	public void setTelephoneMin(Integer telephoneMin) {
		this.telephoneMin = telephoneMin;
	}

	@Column(name="key_printer_min", insertable=false)
	public Integer getPrinterMin() {
		return this.printerMin;
	}

	public void setPrinterMin(Integer printerMin) {
		this.printerMin = printerMin;
	}

	@Column(name="key_fax_min", insertable=false)
	public Integer getFaxMin() {
		return this.faxMin;
	}

	public void setFaxMin(Integer faxMin) {
		this.faxMin = faxMin;
	}

	@Column(name="key_copier_min", insertable=false)
	public Integer getCopierMin() {
		return this.copierMin;
	}

	public void setCopierMin(Integer copierMin) {
		this.copierMin = copierMin;
	}

	@Column(name="key_scanner_min", insertable=false)
	public Integer getScannerMin() {
		return this.scannerMin;
	}

	public void setScannerMin(Integer scannerMin) {
		this.scannerMin = scannerMin;
	}

	@Column(name="key_server_min", insertable=false)
	public Integer getServerMin() {
		return this.serverMin;
	}

	public void setServerMin(Integer serverMin) {
		this.serverMin = serverMin;
	}

	@Column(name="key_workstation_comment", insertable=false)
	public String getWorkstationComment() {
		return this.workstationComment;
	}

	public void setWorkstationComment(String workstationComment) {
		this.workstationComment = workstationComment;
	}

	@Column(name="key_laptop_comment", insertable=false)
	public String getLaptopComment() {
		return this.laptopComment;
	}

	public void setLaptopComment(String laptopComment) {
		this.laptopComment = laptopComment;
	}

	@Column(name="key_telephone_comment", insertable=false)
	public String getTelephoneComment() {
		return this.telephoneComment;
	}

	public void setTelephoneComment(String telephoneComment) {
		this.telephoneComment = telephoneComment;
	}

	@Column(name="key_printer_comment", insertable=false)
	public String getPrinterComment() {
		return this.printerComment;
	}

	public void setPrinterComment(String printerComment) {
		this.printerComment = printerComment;
	}

	@Column(name="key_fax_comment", insertable=false)
	public String getFaxComment() {
		return this.faxComment;
	}

	public void setFaxComment(String faxComment) {
		this.faxComment = faxComment;
	}

	@Column(name="key_copier_comment", insertable=false)
	public String getCopierComment() {
		return this.copierComment;
	}

	public void setCopierComment(String copierComment) {
		this.copierComment = copierComment;
	}

	@Column(name="key_scanner_comment", insertable=false)
	public String getScannerComment() {
		return this.scannerComment;
	}

	public void setScannerComment(String scannerComment) {
		this.scannerComment = scannerComment;
	}

	@Column(name="key_server_comment", insertable=false)
	public String getServerComment() {
		return this.serverComment;
	}

	public void setServerComment(String serverComment) {
		this.serverComment = serverComment;
	}

	@Transient
	public Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> getOfficeEquipmentMinimums() {
		Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> mins = 
			new HashMap<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum>();
		mins.put(OfficeEquipmentMinimum.Type.COPIER, 
			new OfficeEquipmentMinimum(this.getCopierMin(), this.getCopierComment()));
		mins.put(OfficeEquipmentMinimum.Type.FAX, new OfficeEquipmentMinimum(
			this.getFaxMin(), this.getFaxComment()));
		mins.put(OfficeEquipmentMinimum.Type.LAPTOP, new OfficeEquipmentMinimum(
			this.getLaptopMin(), this.getLaptopComment()));
		mins.put(OfficeEquipmentMinimum.Type.PRINTER, new OfficeEquipmentMinimum(
			this.getPrinterMin(), this.getPrinterComment()));
		mins.put(OfficeEquipmentMinimum.Type.SCANNER, new OfficeEquipmentMinimum(
			this.getScannerMin(), this.getScannerComment()));
		mins.put(OfficeEquipmentMinimum.Type.SERVER, new OfficeEquipmentMinimum(
			this.getServerMin(), this.getServerComment()));
		mins.put(OfficeEquipmentMinimum.Type.TELEPHONE, new OfficeEquipmentMinimum(
			this.getTelephoneMin(), this.getTelephoneComment()));
		mins.put(OfficeEquipmentMinimum.Type.WORKSTATION, new OfficeEquipmentMinimum(
			this.getWorkstationMin(), this.getWorkstationComment()));
		return mins;
	}

	@Transient
	public void setOfficeEquipmentMinimums(
			Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> officeEquipmentMinimums) {
		this.init();
		if (officeEquipmentMinimums == null) return;
		Set<OfficeEquipmentMinimum.Type> types = officeEquipmentMinimums.keySet();
		for (OfficeEquipmentMinimum.Type type : types) {
			OfficeEquipmentMinimum req = officeEquipmentMinimums.get(type);
			if (req == null) continue;
			int min = req.getMinRequirement();
			String comment = req.getComment();
			if (type == OfficeEquipmentMinimum.Type.COPIER) {
				this.setCopierMin(min);
				this.setCopierComment(comment);
			} else if (type == OfficeEquipmentMinimum.Type.FAX) {
				this.setFaxMin(min);
				this.setFaxComment(comment);
			} else if (type == OfficeEquipmentMinimum.Type.LAPTOP) {
				this.setLaptopMin(min);
				this.setLaptopComment(comment);
			} else if (type == OfficeEquipmentMinimum.Type.PRINTER) {
				this.setPrinterMin(min);
				this.setPrinterComment(comment);
			} else if (type == OfficeEquipmentMinimum.Type.SCANNER) {
				this.setScannerMin(min);
				this.setScannerComment(comment);
			} else if (type == OfficeEquipmentMinimum.Type.SERVER) {
				this.setServerMin(min);
				this.setServerComment(comment);
			} else if (type == OfficeEquipmentMinimum.Type.TELEPHONE) {
				this.setTelephoneMin(min);
				this.setTelephoneComment(comment);
			} else if (type == OfficeEquipmentMinimum.Type.WORKSTATION) {
				this.setWorkstationMin(min);
				this.setWorkstationComment(comment);
			} else {
			}
		}
	}

	private void init() {
		this.setCopierMin(null);
		this.setCopierComment("");
		this.setFaxMin(null);
		this.setFaxComment("");
		this.setLaptopMin(null);
		this.setLaptopComment("");
		this.setPrinterMin(null);
		this.setPrinterComment("");
		this.setScannerMin(null);
		this.setScannerComment("");
		this.setServerMin(null);
		this.setServerComment("");
		this.setTelephoneMin(null);
		this.setTelephoneComment("");
		this.setWorkstationMin(null);
		this.setWorkstationComment("");
	}

}

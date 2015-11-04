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
package org.kuali.continuity.domain;

import java.sql.Blob;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class SamplePlanDocument implements BinaryDocument {
	
	public final static String SAMPLE_PLAN_FILE_NAME = "SamplePlan.pdf";
	private Integer id;
	private Blob blobDocument;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Transient
	public String getFileName() {
		return SAMPLE_PLAN_FILE_NAME;
	}
	
	@Lob
	public Blob getBlobDocument() {
		return this.blobDocument;
	}

	public void setBlobDocument(Blob blobDocument) {
		this.blobDocument = blobDocument;
	}

}

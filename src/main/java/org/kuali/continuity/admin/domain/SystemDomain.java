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
package org.kuali.continuity.admin.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.SystemDomainAccess;
import org.kuali.continuity.domain.SystemDomainType;

@Entity(name="Domain")
@Table(name="SystemDomain")
@NamedQueries({
    @NamedQuery(name="Domain.list",
        query="SELECT dObj FROM Domain dObj where dObj.systemDomainGroup = :systemDomainGroup"),
    @NamedQuery(name="Domain.size",
        query="SELECT COUNT(dObj) FROM Domain dObj where dObj.systemDomainGroup = :systemDomainGroup"),
    @NamedQuery(name="Domain.all.list",
        query="SELECT dObj FROM Domain dObj"),
    @NamedQuery(name="Domain.all.size",
        query="SELECT COUNT(dObj) FROM Domain dObj")
})
@SuppressWarnings("serial")
public class SystemDomain extends BaseAdminDomainObject {
    
    private byte[] logo;
    private String phone;
    private String fax;
    private String email;
    private SystemDomainAccess systemDomainAccess;
    private SystemDomainSettings settings;
    private boolean isLBNL;
    private boolean isShibMode;    // authentication type - shib (true) or direct login (false)
    private String systemDomainGroup;
    private Set<String> netDomains;
    private String fullModeration;
    private String shibIDP;
    private String systemName;
	private String customUrl;
    private String shibUniqueId;
    
    public enum SortBy implements SortByType {
        id, name, type, systemDomainAccess;
        public String getSortByValue() {return this.name();}
    };
    
    public SystemDomain() {
        super();
    }
    
    public SystemDomain(Integer id) {
        super(id);
    }
    
    @Id
    @Column(name="InstitutionID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId() {
        return super.getId();
    }
    
    @Column(name="Institution")
    public String getName() {
        return super.getName();
    }
    
    public void setName(String name) {
        super.setName(name);
    }
    
    @Transient
    @Deprecated
    // sublocation is obsolete
    public Integer getParentSystemDomainId() {
        return null;
    }
    
    @Deprecated
    public void setParentSystemDomainId(Integer parentSystemDomainId) {
        ;
    }
    
    @Transient
    @Deprecated
    // primary or member is obsolete
    public SystemDomainType getType() {
        return null;
    }
    
    @Deprecated
    public void setType(SystemDomainType type) {
        ;
    }
       
    @Transient
    @Override
    public Integer getSystemDomainId() {
        return this.getId();
    }
    
    @Override
    public void setSystemDomainId(Integer id) {
        this.setId(id);
    }
    
    @Lob
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @ManyToOne
    @JoinColumn(name="InstitutionAccess", nullable=false)
    @Fetch(FetchMode.SELECT)
    public SystemDomainAccess getSystemDomainAccess() {
        return this.systemDomainAccess;
    }
    
    public void setSystemDomainAccess(SystemDomainAccess systemDomainAccess) {
        this.systemDomainAccess = systemDomainAccess;
    }
    
    public SystemDomainSettings getSettings() {
        return this.settings;
    }

    public void setSettings(SystemDomainSettings settings) {
        this.settings = settings;
    }

    @Column(name="LBNLFlag", updatable=false)
    public boolean isLBNL() {
        return this.isLBNL;
    }
    
    public void setLBNL(boolean isLBNL) {
        this.isLBNL = isLBNL;
    }

    @Column(name="AuthType")
    public boolean isShibMode() {
        return this.isShibMode;
    }

    public void setShibMode(boolean isShibMode) {
        this.isShibMode = isShibMode;
    }

    @CollectionOfElements(targetElement=String.class, fetch=FetchType.EAGER)
    @JoinTable(name="NetDomain", joinColumns={@JoinColumn(name="InstitutionID")})
    @Column(name="Name", nullable=false)
    public Set<String> getNetDomains() {
        if (this.netDomains == null)
            this.setNetDomains(new HashSet<String>());
        return this.netDomains;
    }

    public void setNetDomains(Set<String> domains) {
        this.netDomains = domains;
    }
    
    @Transient
    public Boolean isPartialModeratedAccess() {
        if (this.isShibMode()) return true;
        if (this.getFullModeration() != null && this.getFullModeration().trim().length() != 0 && this.getFullModeration().equals("1"))
            return false;
        else
            return true;
    }

    @Column(name="InstGroup")
    public String getSystemDomainGroup() {
        return this.systemDomainGroup;
    }

    public void setSystemDomainGroup(String systemDomainGroup) {
        this.systemDomainGroup = systemDomainGroup;
    }

    @Column(name="Moderation", insertable=false)
    public String getFullModeration() {
    	return this.fullModeration;
    }

    public void setFullModeration(String fullModeration) {
        this.fullModeration = fullModeration;
    }

    @Column(name="AuthLocation")
    public String getShibIDP() {
		return this.shibIDP;
	}

	public void setShibIDP(String shibIDP) {
		this.shibIDP = shibIDP;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

    public String getCustomUrl() {
		return this.customUrl;
	}

	public void setCustomUrl(String customUrl) {
		this.customUrl = customUrl;
	}

	public String getShibUniqueId() {
		return this.shibUniqueId;
	}

	@Transient
	public boolean isDemo() {
		return 
			this.getCustomUrl() != null && 
			this.getCustomUrl().trim().equalsIgnoreCase("demo");
	}

	public void setShibUniqueId(String shibUniqueId) {
		this.shibUniqueId = shibUniqueId;
	}

	@PrePersist
	@PreUpdate
	public void checkNullInserts() {
		if (this.getShibIDP() == null)
			this.setShibIDP("");
		if (this.getFullModeration() == null)
			this.setFullModeration("");
	}

} 
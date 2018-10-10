package com.bluespace.tech.hrms.security.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class CompanyRegistration extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private String companyName;
	@Getter @Setter private String description;
	@Getter @Setter private boolean approved = false;
	
	public String toString() {
		return "CompanyRegistration [companyName=" + this.companyName + ", description=" + this.description + ", id="
				+ get_id() + "]";
	}

}
package com.bluespace.tech.hrms.security.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.security.constants.RoleConstants;

import lombok.Getter;
import lombok.Setter;

@Document
public class UserRoleAuthority extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private RoleConstants authorizedRole;
	@Getter @Setter private UserRole userRole;

}

package com.bluespace.tech.hrms.security.domain;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAccount extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
	private String userType;
	private String email;
	private Collection<String> roles;
	private Collection<String> uiRoles;

}

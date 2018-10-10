package com.bluespace.tech.hrms.security.domain;

import java.util.Date;

/*import java.io.Serializable;
import java.util.Collection;
import java.util.Date;*/

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.general.Roles;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*@Document
@Data
@EqualsAndHashCode(callSuper=false)
public class UserRole extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String roleName;
	private String description;
	private Date createdOn;
	private User modifiedBy;
	private Date modifiedOn;
	private Collection<UserRoleAuthority> userRoleAuthorities;

}*/

@Document
@Data
@EqualsAndHashCode(callSuper=false)
public class UserRole {

	@Id private ObjectId _id;
	@DBRef private Roles roles;
	@DBRef private User userInfo;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	
}
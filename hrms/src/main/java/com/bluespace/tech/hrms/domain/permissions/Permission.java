package com.bluespace.tech.hrms.domain.permissions;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.role.Role;
import com.bluespace.tech.hrms.security.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

	@Getter @Setter @Id private int id;
	@Getter @Setter private List<Role> role;
	@Getter @Setter private List<Control> control;
	@Getter @Setter private boolean value;
	@Getter @Setter private Date createdOn;
	@Getter @Setter private List<User> createdBy;
	@Getter @Setter private Date modifiedOn;
	@Getter @Setter private List<User> modifiedBy;
	
}
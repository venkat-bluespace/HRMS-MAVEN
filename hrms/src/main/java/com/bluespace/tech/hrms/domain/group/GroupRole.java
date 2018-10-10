package com.bluespace.tech.hrms.domain.group;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.role.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="grouprole")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRole {

	 @Id private int id;
	 private String groupName;
	 @DBRef private Collection<Role> role;
	 @DBRef private List<Groups> group;
	 private Date assignedOn;
	 
}
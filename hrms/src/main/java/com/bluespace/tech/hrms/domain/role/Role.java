package com.bluespace.tech.hrms.domain.role;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.domain.general.CurrentStatus;
import com.bluespace.tech.hrms.security.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Getter @Setter private int id;
	@Getter @Setter private String roleName;
	@Getter @Setter private String roleDesc;
	@Getter @Setter @DBRef private List<Client> client;
	@Getter @Setter private CurrentStatus accountStatus;
	@Getter @Setter private Date createdOn;
	@Getter @Setter private User createdBy;
	@Getter @Setter private Date modifiedOn;
	@Getter @Setter private User modifiedBy;

}
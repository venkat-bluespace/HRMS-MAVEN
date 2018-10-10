package com.bluespace.tech.hrms.domain.group;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
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

@Document(collection="groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groups {

	@Getter @Setter @Id private int id;
	@Getter @Setter private String groupName;
	@Getter @Setter private String groupDesc;
	@Getter @Setter @DBRef private List<CurrentStatus> status;
	@Getter @Setter @DBRef private List<Client> client;
	@Getter @Setter private Date createdOn;
	@Getter @Setter @DBRef private User createdBy;
	@Getter @Setter @DBRef private List<User> modifiedBy;
	@Getter @Setter private Date modifiedOn;
	
}

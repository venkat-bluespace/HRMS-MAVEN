package com.bluespace.tech.hrms.domain.member.details;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.domain.general.Person;
//import com.bluespace.tech.hrms.security.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="lead")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead {

	enum Status {
		PASSIVE, TRAINING, INTERVIEW_SCHEDULE, OFFERED, ONBOARD, ACTIVE, DELETED
	}

	@Getter @Setter @Id private int id;
	@Getter @Setter private Person person;
	@Getter @Setter private String source;
	@Getter @Setter private String presentJobTitle;
	@Getter @Setter private String persentCompany;
	@Getter @Setter private String domain;
	@Getter @Setter private String communication_EmailAddress;
	@Getter @Setter private String userName;
	@Getter @Setter @DBRef private List<Client> client;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Date lastUpdatedDate;
	@Getter @Setter private Status status;
	//@Getter @Setter @DBRef private List<User> marketingExecutive;
	
}
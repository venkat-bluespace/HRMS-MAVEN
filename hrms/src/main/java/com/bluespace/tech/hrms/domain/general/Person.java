package com.bluespace.tech.hrms.domain.general;

import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "person")
@Data
@ManagedBean
@ApplicationScope
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id private int id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String phoneNumber;
	private String mobileNumber;
	private String otherName;
	private String emailAddress;
	@DBRef private List<CurrentStatus> currentStatus;
	private Date dateCreated;
	private Date lastUpdatedDate;

}

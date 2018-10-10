package com.bluespace.tech.hrms.domain.general;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
//import com.bluespace.tech.hrms.domain.member.details.Lead;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "communicationpreferences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationPreferences {

	@Id private ObjectId id;
	private boolean smsOptIn;
	private boolean emailOptIn;
	@DBRef private EmployeeDetails employeeId;
	private String facebookURL;
	private String linkedInURL;
	private String twitterURL;
	private String mobileNumber;
/*	private String workNumber;
	private String homeNumber;
	@DBRef private List<Lead> lead;*/
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;

}
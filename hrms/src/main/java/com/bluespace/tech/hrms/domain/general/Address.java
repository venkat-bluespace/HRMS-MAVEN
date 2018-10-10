package com.bluespace.tech.hrms.domain.general;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id private ObjectId id;
	private Integer addressId;
	@DBRef private AddressType addressType;	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String state;
//	private String countryCode;
	private String country;
	private String zipCode;
	@DBRef private Client client;
	@DBRef private EmployeeDetails employeeDetails;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;

}

package com.bluespace.tech.hrms.domain.general;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "addressrelationship")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRelationship {

	@Id private ObjectId id;
	@DBRef private Address addressId;
	@DBRef private Client clientId;
	@DBRef private EmployeeDetails employeeId;
	
}
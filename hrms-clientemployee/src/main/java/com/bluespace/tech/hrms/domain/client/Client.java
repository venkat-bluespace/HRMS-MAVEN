package com.bluespace.tech.hrms.domain.client;

//import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.general.Address;
import com.bluespace.tech.hrms.domain.general.CurrentStatus;
//import com.bluespace.tech.hrms.security.domain.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
//public class Client extends BaseDomain implements Serializable {
  public class Client {
//	private static final long serialVersionUID = 1L;

	@Id
	private ObjectId _id;
	private long clientId;
	private String clientName;
	private Integer federalId;
	private Integer stateId;
	private String phoneNumber;
	private String companyURL;
	private String emailAddress;
	private long employeeStrength;
	private Date incorporatedDate;
	private String incorporatedState;
	private Integer dunsId;
	private Integer nacisCode;
	private boolean isActive;
	private boolean isVendor;
	private boolean isEndClient;
	private boolean accountExpired;
	private boolean accountLocked;
	@DBRef private List<Address> address;
	@DBRef private List<CurrentStatus> currentStatus;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;

}
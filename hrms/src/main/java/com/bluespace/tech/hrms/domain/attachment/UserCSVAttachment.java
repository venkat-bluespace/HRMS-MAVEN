package com.bluespace.tech.hrms.domain.attachment;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.client.Client;
import com.bluespace.tech.hrms.security.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "usercsvattachment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCSVAttachment {

	static public enum Status {
		NOTSTARTED, 
		INPROGRESS, 
		COMPLETED, 
		DELETED, 
		MAPPINGINCOMPLETE, 
		COMPLETEDWITHDUPLICATES, 
		ERROR_PROCESSING_CSV
	}

    @Getter @Setter @Id private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private byte[] fileAttachment;
    @Getter @Setter private long size;
    @Getter @Setter private Date uploadedDate;
    @Getter @Setter private String source;
    @Getter @Setter private String sendSMSNotification;
    @Getter @Setter private String excludeFromMassCommunication;
    @Getter @Setter @DBRef private List<Client> client;
    @Getter @Setter private String mappingParams;
    @Getter @Setter @DBRef private List<Status> currentStatus;
    @Getter @Setter @DBRef private List<User> user;
    @Getter @Setter private String action;
    @Getter @Setter private String errorMessage;
    @Getter @Setter private boolean hasHeaderRow;
    @Getter @Setter private int numberOfRows;
}

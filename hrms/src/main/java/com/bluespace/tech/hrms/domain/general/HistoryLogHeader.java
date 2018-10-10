package com.bluespace.tech.hrms.domain.general;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.security.domain.User;

import lombok.Data;

@Document
@Data
public class HistoryLogHeader {

	@Id private ObjectId id;
	@DBRef private User userName;
	private Date createdOn;
	private Integer historyId;
	private Integer changeRecordNumber;
	
}
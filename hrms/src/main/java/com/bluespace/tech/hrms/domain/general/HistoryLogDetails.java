package com.bluespace.tech.hrms.domain.general;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class HistoryLogDetails {

	@Id private ObjectId id;
	@DBRef private HistoryLogHeader historyId;
	private String oldValue;
	private String newValue;
	@DBRef private HistoryLogHeader changeRecordNumber;
	
}
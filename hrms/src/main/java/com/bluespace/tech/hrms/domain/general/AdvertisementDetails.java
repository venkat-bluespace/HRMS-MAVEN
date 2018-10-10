package com.bluespace.tech.hrms.domain.general;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.member.details.Lead;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "advertisementdetails")
public class AdvertisementDetails {

	static public enum Visiblity {
		PUBLIC, PRIVATE
	}

	static public enum Type {
		VIDEO, AUDIO, WEBURL
	}

	@Getter @Setter @Id private int id;
	@Getter @Setter private Lead lead;
	@Getter @Setter private String url;
	@Getter @Setter private Visiblity visibility;
	@Getter @Setter @DBRef private List<CurrentStatus> status;
	@Getter @Setter private Date dateCreated;
	@Getter @Setter private Date lastUpdatedDate;
	@Getter @Setter private Type addType;
}

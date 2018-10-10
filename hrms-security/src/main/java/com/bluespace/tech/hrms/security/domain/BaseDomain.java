package com.bluespace.tech.hrms.security.domain;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

public abstract class BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @Getter private ObjectId _id;
	@Getter private Long version;
	@Getter @Setter private Date lastUpdatedDate;
	@Getter @Setter private String lastUpdatedUser;
	@Getter @Setter private Date creationDate;
	@Getter @Setter private String createdUser;
	@Getter @Setter private transient Long resourceObjectId;
	@Getter @Setter private transient boolean autoRunEnabled;
//	private final transient String AUTO_ADMIN = "auto_admin";
	
	public Date cloneDate(Date date) {
		return date != null ? (Date) date.clone() : null;
	}

	public Date cloneTimestamp(Date timestamp) {
		return timestamp != null ? (Date) timestamp.clone() : null;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BaseDomain other = (BaseDomain) obj;
		if (this._id == null) {
			if (other._id != null) {
				return false;
			}
		} else if (!this._id.equals(other._id)) {
			return false;
		}
		return true;
	}

}

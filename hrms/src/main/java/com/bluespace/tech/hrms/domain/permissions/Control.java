package com.bluespace.tech.hrms.domain.permissions;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluespace.tech.hrms.domain.general.CurrentStatus;
import com.bluespace.tech.hrms.security.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="controls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Control {
	
	static public enum Type {
		TEXT, 
		TEXT_AREA, 
		CHECK_BOX, 
		MULTI_SELECT
	}

	@Getter @Setter @Id private int id;
	@Getter @Setter private String controlKey;
	@Getter @Setter private String controlName;
	@Getter @Setter private CurrentStatus status;
	@Getter @Setter private Type type;
	@Getter @Setter private Date createdOn;
	@Getter @Setter private User createdBy;
	@Getter @Setter private Date modifedOn;
	@Getter @Setter private User modifiedBy;
	
}

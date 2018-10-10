package com.bluespace.tech.hrms.security.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class DefaultResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	  @Getter @Setter private long responseCode;
	  @Getter @Setter private String responseMessage;
	  @Getter @Setter private long errorCode;
	  @Getter @Setter private String errorMessage;

}
package com.bluespace.tech.hrms.security.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private long responseCode;
	private String responseMessage;
	private long errorCode;
	private String errorMessage;

}

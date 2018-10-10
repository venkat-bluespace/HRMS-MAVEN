package com.bluespace.tech.hrms.security.core.exception;

public class BusinessException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public BusinessException(Throwable cause) {
		super(cause);
		initCause(cause);
	}

	public BusinessException(String message) {
		super(message);
	}

}

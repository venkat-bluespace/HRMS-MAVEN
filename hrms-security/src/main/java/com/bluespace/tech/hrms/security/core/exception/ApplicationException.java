package com.bluespace.tech.hrms.security.core.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApplicationException(Throwable cause) {
		super(cause);
		initCause(cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

}

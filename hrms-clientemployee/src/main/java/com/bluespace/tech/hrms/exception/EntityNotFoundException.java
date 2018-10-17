package com.bluespace.tech.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6471612618622813362L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
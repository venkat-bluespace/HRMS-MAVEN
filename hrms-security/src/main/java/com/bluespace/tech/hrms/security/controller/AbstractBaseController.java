package com.bluespace.tech.hrms.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.access.AccessDeniedException;

import com.bluespace.tech.hrms.exception.ApplicationException;
import com.bluespace.tech.hrms.exception.BusinessException;
import com.bluespace.tech.hrms.security.core.ExceptionResource;
import com.bluespace.tech.hrms.security.core.ExceptionResourceAssembler;

public class AbstractBaseController {

	@ExceptionHandler({ AccessDeniedException.class })
	ResponseEntity<ExceptionResource> handleAccessDeniedException(Exception e) {
		System.out.println("Access Denied handler : " + e.getMessage());
		ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
		return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler({ BusinessException.class })
	ResponseEntity<ExceptionResource> handleBusinessException(BusinessException e) {
		ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
		return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ ApplicationException.class })
	ResponseEntity<ExceptionResource> handleApplicationException(ApplicationException e) {
		ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
		return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ RuntimeException.class })
	ResponseEntity<ExceptionResource> handleRuntimeException(RuntimeException e) {
		ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
		return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Exception.class })
	ResponseEntity<ExceptionResource> handleUnHandledException(Exception e) {
		ExceptionResource exceptionResource = ExceptionResourceAssembler.toResource(e);
		return new ResponseEntity<ExceptionResource>(exceptionResource, HttpStatus.BAD_REQUEST);
	}
}

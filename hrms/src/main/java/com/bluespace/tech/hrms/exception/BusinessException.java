package com.bluespace.tech.hrms.exception;

public class BusinessException extends ApplicationException {
	
	private static final long serialVersionUID = 6326904172528480702L;

	public BusinessException(Throwable cause)
	  {
	    super(cause);
	    initCause(cause);
	  }
	  
	  public BusinessException(String message)
	  {
	    super(message);
	  }

}
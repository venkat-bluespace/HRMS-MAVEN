package com.bluespace.tech.hrms.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 5131232075400121557L;
	
	  public ApplicationException(String message)
	  {
	    super(message);
	  }
	  
	  public ApplicationException(Throwable cause)
	  {
	    super(cause);
	  }

}
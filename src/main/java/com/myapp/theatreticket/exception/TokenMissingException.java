package com.myapp.theatreticket.exception;

/**
 * @author Ravi
 *
 */

public class TokenMissingException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TokenMissingException() {
	    super("Bearer Token must be passed ");
	 }
	
}

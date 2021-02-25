package com.myapp.theatreticket.exception;

/**
 * @author Ravi
 *
 */

public class TicketNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TicketNotFoundException(long id) {
	    super("Could not find Ticket " + id);
	 }
	
}

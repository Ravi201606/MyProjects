package com.myapp.theatreticket.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ravi
 *
 */
@ControllerAdvice
public class TokenMissingAdvice {

	@ResponseBody
	@ExceptionHandler(TokenMissingException.class)
	ResponseEntity<Object> bookingNotFoundHandler(HttpServletRequest request, TokenMissingException ex) {
		Error error = new Error();
		error.setCode(101);
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST);
		error.setPath(request.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

package com.myapp.theatreticket.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.theatreticket.model.TheatreTicketResponse;

/**
 * @author Ravi
 *
 */
@ControllerAdvice
public class TicketNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(TicketNotFoundException.class)
	ResponseEntity<Object> bookingNotFoundHandler(HttpServletRequest request, TicketNotFoundException ex) {
		TheatreTicketResponse response = new TheatreTicketResponse();
		List<Error> errors = new ArrayList<>();
		Error error = new Error();
		error.setCode(100);
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setPath(request.getRequestURI());
		errors.add(error);
		response.setErrors(errors);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}

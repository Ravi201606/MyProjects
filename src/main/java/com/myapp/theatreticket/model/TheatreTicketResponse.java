package com.myapp.theatreticket.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myapp.theatreticket.exception.Error;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ravi
 *
 */

@JsonInclude(Include.NON_NULL)
public class TheatreTicketResponse {

	@Getter @Setter private Boolean success;
	@Getter @Setter private List<Error> errors;
}

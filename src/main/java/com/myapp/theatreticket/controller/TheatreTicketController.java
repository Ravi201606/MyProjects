package com.myapp.theatreticket.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.theatreticket.dataaccess.TheatreTicket;
import com.myapp.theatreticket.model.MoneyEarnedAnalytics;
import com.myapp.theatreticket.model.PeopleVisitedAnalytics;
import com.myapp.theatreticket.model.TheatreTicketResponse;
import com.myapp.theatreticket.service.TheatreTicketService;

/**
 * @author Ravi
 *
 */
@RestController
public class TheatreTicketController {
	
	@Autowired
	private TheatreTicketService service;

	@PostMapping("/v1/ticket")
	@ResponseStatus(HttpStatus.CREATED)
	public TheatreTicketResponse createBooking(@RequestBody TheatreTicket ticket) {
		return service.createTicket(ticket);
	}
	
	@GetMapping("/v1/ticket/{ticketReference}")
	public TheatreTicket getBooking(@PathVariable long ticketReference) {
		return service.getTicketById(ticketReference);
	}
	
	@PutMapping("/v1/ticket/{ticketReference}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateBooking(@RequestBody TheatreTicket ticket, @PathVariable long ticketReference){
		service.updateTicket(ticket,ticketReference);
	}
	
	@DeleteMapping("/v1/ticket/{ticketReference}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBooking(@PathVariable long ticketReference) {
		service.deleteTicket(ticketReference);
	}
	
	@GetMapping("/v1/ticket/analytics/people/visited")
	public PeopleVisitedAnalytics findPeopleVisitedByFromAndToDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date fromDate,
			@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date toDate) {
		return service.findPeopleVisitedByFromAndToDate(fromDate, toDate);
	}
	
	@GetMapping("/v1/ticket/analytics/money/earned")
	public MoneyEarnedAnalytics findMoneyEarnedByFromAndToDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date fromDate,
			@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date toDate) {
		return service.findMoneyEarnedByFromAndToDate(fromDate, toDate);
	}
}

package com.myapp.theatreticket.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.theatreticket.dataaccess.TheatreTicket;
import com.myapp.theatreticket.dataaccess.TheatreTicketRepository;
import com.myapp.theatreticket.exception.TicketNotFoundException;
import com.myapp.theatreticket.model.AnalyticsResponse;
import com.myapp.theatreticket.model.MoneyEarnedAnalytics;
import com.myapp.theatreticket.model.PeopleVisitedAnalytics;
import com.myapp.theatreticket.model.TheatreTicketResponse;

/**
 * @author Ravi
 *
 */

@Service
public class TheatreTicketService {
	
	@Autowired
	private TheatreTicketRepository repository;
	
	@Autowired
	private SequenceGeneratorService service;

	public TheatreTicketResponse createTicket(TheatreTicket ticket) {
		TheatreTicketResponse response = new TheatreTicketResponse();
		ticket.setCreationDate(new Date());
		ticket.setId(service.getSequenceNumber("db_sequence"));
		repository.save(ticket);
		response.setSuccess(true);
		return response;
	}

	public TheatreTicket getTicketById(long ticketReference) {
		return repository.findById(ticketReference).orElseThrow(() -> new TicketNotFoundException(ticketReference));
	}

	public void updateTicket(TheatreTicket theatreTicket,long ticketReference) {
		TheatreTicket ticket = repository.findById(ticketReference).orElseThrow(() -> new TicketNotFoundException(ticketReference));
		theatreTicket.setId(ticketReference);
		theatreTicket.setCreationDate(ticket.getCreationDate());
		repository.save(theatreTicket);
	}

	public void deleteTicket(long ticketReference) {
		repository.deleteById(ticketReference);
	}

	public PeopleVisitedAnalytics findPeopleVisitedByFromAndToDate(Date fromDate, Date toDate) {
		List<AnalyticsResponse> responseList = new ArrayList<AnalyticsResponse>();
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		PeopleVisitedAnalytics analytics = new PeopleVisitedAnalytics();
		repository.findByCreationDateBetween(fromDate, toDate).stream().forEach(ticket -> {
			LocalDate date = ticket.getCreationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			String month = date.getMonth().toString();
			if(dataMap.get(month)!=null) {
				dataMap.put(month, dataMap.get(month)+1);
			}else {
				dataMap.put(month, 1);
			}
		});
		
		dataMap.forEach((k,v) -> {
			AnalyticsResponse response = new AnalyticsResponse();
			response.setMonth(k);
			response.setSummaryVisits(v);
			responseList.add(response);
		});
		
		analytics.setResponse(responseList);
		return analytics;
	}

	public MoneyEarnedAnalytics findMoneyEarnedByFromAndToDate(Date fromDate, Date toDate) {
		List<AnalyticsResponse> responseList = new ArrayList<AnalyticsResponse>();
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		MoneyEarnedAnalytics analytics = new MoneyEarnedAnalytics();
		repository.findByCreationDateBetween(fromDate, toDate).stream().forEach(ticket -> {
			LocalDate date = ticket.getCreationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			String month = date.getMonth().toString();
			if(dataMap.get(month)!=null) {
				dataMap.put(month, dataMap.get(month)+ticket.getTicketPrice());
			}else {
				dataMap.put(month, ticket.getTicketPrice());
			}
		});
		
		dataMap.forEach((k,v) -> {
			AnalyticsResponse response = new AnalyticsResponse();
			response.setMonth(k);
			response.setSummaryProfit(v);
			responseList.add(response);
		});
		
		analytics.setResponse(responseList);
		return analytics;
	}

}

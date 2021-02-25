package com.myapp.theatreticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.theatreticket.dataaccess.TheatreTicket;
import com.myapp.theatreticket.dataaccess.TheatreTicketRepository;
import com.myapp.theatreticket.model.TheatreTicketResponse;
import com.myapp.theatreticket.service.TheatreTicketService;

@SpringBootTest
class TheatreTicketApplicationTests {

	@Autowired
	private TheatreTicketService service;
	
	@MockBean
	private TheatreTicketRepository repository;
	
	@Test
	public void getTicketTest() {
		when(repository.findById(1l)).thenReturn(Optional.of(getTicket()));
		assertEquals("Test", service.getTicketById(1l).getCustomerName());
		assertEquals("TENET", service.getTicketById(1l).getPerformanceTitle());
		assertEquals(100, service.getTicketById(1l).getTicketPrice());
	}
	
	@Test
	public void createTicketTest() {
		when(repository.save(any(TheatreTicket.class))).thenReturn(newTicket());
		TheatreTicketResponse response = service.createTicket(newTicket());
		assertEquals(true, response.getSuccess());
	}
	
	@Test
	public void deleteTicketTest() {
		service.deleteTicket(1);
		verify(repository, times(1)).deleteById(1l);
	}

	private TheatreTicket getTicket() {
		TheatreTicket ticket = new TheatreTicket();
		ticket.setCreationDate(new Date());
		ticket.setCustomerName("Test");
		ticket.setPerformanceTime(new Date());
		ticket.setPerformanceTitle("TENET");
		ticket.setTicketPrice(100);
		return ticket;
	}
	
	private TheatreTicket newTicket() {
		TheatreTicket ticket = new TheatreTicket();
		ticket.setId(10);
		ticket.setCustomerName("Test");
		ticket.setPerformanceTime(new Date());
		ticket.setPerformanceTitle("TENET");
		ticket.setTicketPrice(200);
		return ticket;
	}

}

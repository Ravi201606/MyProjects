package com.myapp.theatreticket.dataaccess;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ravi
 *
 */
@Repository
public interface TheatreTicketRepository extends MongoRepository<TheatreTicket,Long>{

	public List<TheatreTicket> findByCreationDateBetween(Date from, Date to);
}

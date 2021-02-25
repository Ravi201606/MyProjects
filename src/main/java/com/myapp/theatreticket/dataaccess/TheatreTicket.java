package com.myapp.theatreticket.dataaccess;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Ravi
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TheatreTicket {

	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@JsonIgnore
	@Getter @Setter public long id;
	@Getter @Setter @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm") public Date creationDate;
	@Getter @Setter public String customerName;
	@Getter @Setter public String performanceTitle;
	@Getter @Setter @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm") public Date performanceTime;
	@Getter @Setter public int ticketPrice;
	
}

package com.myapp.theatreticket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ravi
 *
 */
@JsonInclude(Include.NON_NULL)
public class AnalyticsResponse {
	
	@Setter @Getter private String month;
	@Setter @Getter private Integer summaryProfit;
	@Setter @Getter private Integer summaryVisits;

}

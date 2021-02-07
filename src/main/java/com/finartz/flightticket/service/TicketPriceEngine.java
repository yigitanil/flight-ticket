package com.finartz.flightticket.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;

@Component
public class TicketPriceEngine {

    public BigDecimal ticketPrice(BigDecimal basedTicketPrice, int quota, int numberOfSoldTickets) {
        BigDecimal increaseRate  = BigDecimal.valueOf(numberOfSoldTickets)
                .divide(BigDecimal.valueOf(quota), MathContext.DECIMAL32);

        return basedTicketPrice.multiply(BigDecimal.ONE.add(increaseRate));
    }
}

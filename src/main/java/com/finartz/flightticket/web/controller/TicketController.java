package com.finartz.flightticket.web.controller;

import com.finartz.flightticket.service.TicketService;
import com.finartz.flightticket.web.model.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airlines/{airlineId}/flights/{flightId}/tickets")
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/{ticketId}")
    public TicketDto getTicket(@PathVariable Long ticketId){
        return ticketService.getTicketById(ticketId);
    }

    @GetMapping
    public List<TicketDto> getAllTicketsByFlight(@PathVariable Long flightId){
        return ticketService.getAllTicketsByFlightId(flightId);
    }

    @PostMapping
    public TicketDto buyTicket(@PathVariable Long airlineId,
                               @PathVariable Long flightId,
                               @RequestBody TicketDto ticketDto){
        return ticketService.buyTicket(airlineId, flightId, ticketDto);
    }
}

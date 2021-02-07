package com.finartz.flightticket.service;

import com.finartz.flightticket.domain.Flight;
import com.finartz.flightticket.domain.Ticket;
import com.finartz.flightticket.repository.AirlineRepository;
import com.finartz.flightticket.repository.FlightRepository;
import com.finartz.flightticket.repository.TicketRepository;
import com.finartz.flightticket.web.exception.FlightException;
import com.finartz.flightticket.web.mapper.TicketMapper;
import com.finartz.flightticket.web.model.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;
    private final AirlineRepository airlineRepository;
    private final TicketPriceEngine ticketPriceEngine;
    private final CreditCardEngine creditCardEngine;
    private final TicketMapper ticketMapper;

    @Override
    public TicketDto getTicketById(Long id) {
        return ticketMapper.ticketToTicketDto(ticketRepository.findById(id)
                .orElseThrow(() -> new FlightException("Ticket could not be found.")));
    }

    @Override
    public List<TicketDto> getAllTicketsByFlightId(Long flightId) {
        return ticketRepository.getTicketsByFlight_Id(flightId)
                .stream()
                .map(ticketMapper::ticketToTicketDto)
                .collect(Collectors.toList());
    }


    @Transactional
    @Override
    public TicketDto buyTicket(Long airlineId, Long flightId, TicketDto ticketDto) {
        airlineRepository.findById(airlineId)
                .orElseThrow(() -> new FlightException("Airline could not be found."));

        Flight flight = flightRepository
                .findById(flightId)
                .orElseThrow(() -> new FlightException("Flight could not be found."));

        //validate credit card
        String creditCardNumber = ticketDto.getCreditCardNumber();
        creditCardEngine.validateCreditCard(creditCardNumber);

        //mask credit card
        ticketDto.setCreditCardNumber(creditCardEngine.maskCreditCard(creditCardNumber));

        Ticket ticket = ticketMapper.ticketDtoToTicket(ticketDto);
        ticket.setFlight(flight);

        Ticket savedTicket = ticketRepository.save(ticket);

        if (flight.getTickets().size() == 0) {
            flight.setFlightPrice(flight.getBasedFlightPrice());
        } else {
            flight.setFlightPrice(ticketPriceEngine.ticketPrice(flight.getBasedFlightPrice(), flight.getQuota(),
                    flight.getTickets().size()));
        }

        //update flight price
        flightRepository.save(flight);

        return ticketMapper.ticketToTicketDto(savedTicket);
    }

    @Override
    public void deleteTicket(Long id) {

    }
}

package com.finartz.flightticket.web.mapper;

import com.finartz.flightticket.domain.Ticket;
import com.finartz.flightticket.web.model.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TicketMapper {
    @Mappings({
            @Mapping(target = "payment.creditCardNumber", source = "creditCardNumber")
    })
    Ticket ticketDtoToTicket(TicketDto ticketDto);

    @Mappings({
            @Mapping(target = "airlineName", source = "flight.airline.airlineName"),
            @Mapping(target = "flightNo", source = "flight.flightNo"),
            @Mapping(target = "departureLine", source = "flight.rota.departureLine.airportName"),
            @Mapping(target = "arrivalLine", source = "flight.rota.arrivalLine.airportName"),
            @Mapping(target = "dateTime", source = "flight.date"),
            @Mapping(target = "creditCardNumber", source = "payment.creditCardNumber")
    })
    TicketDto ticketToTicketDto(Ticket ticket);
}
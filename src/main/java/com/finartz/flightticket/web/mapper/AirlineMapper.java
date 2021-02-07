package com.finartz.flightticket.web.mapper;

import com.finartz.flightticket.domain.Airline;
import com.finartz.flightticket.web.model.AirlineDto;
import org.mapstruct.Mapper;

@Mapper
public interface AirlineMapper {
    Airline airlineDtoToAirline(AirlineDto airlineDto);

    AirlineDto airlineToAirlineDto(Airline airline);
}

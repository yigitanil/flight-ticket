package com.finartz.flightticket.web.mapper;

import com.finartz.flightticket.domain.Airport;
import com.finartz.flightticket.web.model.AirportDto;
import org.mapstruct.Mapper;

@Mapper
public interface AirportMapper {
    Airport airportDtoToAirport(AirportDto airportDto);

    AirportDto airportToAirportDto(Airport airport);
}

package com.finartz.flightticket.web.mapper;

import com.finartz.flightticket.domain.Flight;
import com.finartz.flightticket.web.model.FlightDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface FlightMapper {
    @Mapping(target = "rota", source = "rotaDto")
    Flight flightDtoToFlight(FlightDto flightDto);

    @Mappings({
            @Mapping(target = "rotaDto", source = "rota")
    })
    FlightDto flightToFlightDto(Flight flight);
}

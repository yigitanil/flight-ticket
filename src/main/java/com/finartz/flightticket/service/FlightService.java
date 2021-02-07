package com.finartz.flightticket.service;

import com.finartz.flightticket.web.model.FlightDto;

import java.util.List;


public interface FlightService {
    FlightDto getFlightById(Long id);

    List<FlightDto> getAllFlights();

    FlightDto saveFlight(Long airlineId, FlightDto flightDto);
}

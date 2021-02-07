package com.finartz.flightticket.web.controller;

import com.finartz.flightticket.service.FlightService;
import com.finartz.flightticket.web.model.FlightDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airlines/{airlineId}/flights")
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    public List<FlightDto> getFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/{flightId}")
    public FlightDto getFlight(@PathVariable Long flightId){
        return flightService.getFlightById(flightId);
    }

    @PostMapping
    public FlightDto saveFlight(@PathVariable Long airlineId, @RequestBody FlightDto flightDto){
        return flightService.saveFlight(airlineId, flightDto);
    }
}

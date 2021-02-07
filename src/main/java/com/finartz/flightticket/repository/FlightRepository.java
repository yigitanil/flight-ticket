package com.finartz.flightticket.repository;

import com.finartz.flightticket.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}

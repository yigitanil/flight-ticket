package com.finartz.flightticket.bootsrap;

import com.finartz.flightticket.domain.*;
import com.finartz.flightticket.repository.*;
import com.finartz.flightticket.web.mapper.RotaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
    private final AirportRepository airportService;
    private final AirlineRepository airlineService;
    private final RotaRepository rotaService;
    private final FlightRepository flightService;
    private final RotaMapper rotaMapper;
    private final TicketRepository ticketRepository;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (airlineService.count() == 0) {
            Airport ataturkAirport = Airport.builder()
                    .airportName("Ataturk Airport")
                    .build();

            airportService.save(ataturkAirport);

            Airport dalamanAirport = Airport.builder()
                    .airportName("Dalaman Airport")
                    .build();

            airportService.save(dalamanAirport);

            Rota ataturkToDalamanRota = Rota.builder()
                    .departureLine(ataturkAirport)
                    .arrivalLine(dalamanAirport)
                    .build();

            rotaService.save(ataturkToDalamanRota);

            Rota dalamanToAtaturkRota = Rota.builder()
                    .departureLine(dalamanAirport)
                    .arrivalLine(ataturkAirport)
                    .build();

            rotaService.save(dalamanToAtaturkRota);

            Set<Flight> flights = new HashSet<>();
            Flight flight = Flight.builder()
                    .flightNo("TK-102")
                    .quota(100)
                    .basedFlightPrice(new BigDecimal(100))
                    .flightPrice(new BigDecimal(100))
                    .rota(ataturkToDalamanRota)
                    .date(LocalDateTime.now())
                    .build();
            flights.add(flight);

            Airline turkishAirline = Airline.builder()
                    .airlineName("Turkish Airlines")
                    .flights(flights)
                    .build();

            flight.setAirline(turkishAirline);

            airlineService.save(turkishAirline);

            Payment payment = Payment.builder()
                    .creditCardNumber("11111111111111")
                    .build();


            Ticket ticket = Ticket.builder()
                    .flight(flight)
                    .pnrNo("ABCDE")
                    .payment(payment)
                    .build();

            ticketRepository.save(ticket);
        }
    }
}

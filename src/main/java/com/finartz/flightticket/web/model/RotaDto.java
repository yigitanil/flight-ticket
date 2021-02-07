package com.finartz.flightticket.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RotaDto {
    private Long id;
    private AirportDto departureLine;
    private AirportDto arrivalLine;
}

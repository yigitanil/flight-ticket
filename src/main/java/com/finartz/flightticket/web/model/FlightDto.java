package com.finartz.flightticket.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDto {
    private Long id;
    private String flightNo;
    private RotaDto rotaDto;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    private Integer quota;

    private BigDecimal flightPrice;
}

package com.finartz.flightticket.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
    private Long id;
    private String pnrNo;

    private String airlineName;

    private String flightNo;

    private String departureLine;
    private String arrivalLine;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    private String creditCardNumber;
}

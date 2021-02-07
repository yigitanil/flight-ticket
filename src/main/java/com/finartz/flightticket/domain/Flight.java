package com.finartz.flightticket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"airline"})
@ToString(exclude = {"airline"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNo;

    @JsonIgnore
    @ManyToOne
    private Airline airline;

    @OneToOne
    private Rota rota;

    private LocalDateTime date;

    private Integer quota;

    private BigDecimal basedFlightPrice;

    private BigDecimal flightPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
    private Set<Ticket> tickets;
}

package com.finartz.flightticket.domain;

import com.finartz.flightticket.domain.base.BaseEntity;
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
public class Flight extends BaseEntity {


    private String flightNo;

    @ManyToOne
    private Airline airline;

    @OneToOne
    private Route route;

    private LocalDateTime date;

    private Integer quota;

    private BigDecimal basedFlightPrice;

    private BigDecimal flightPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flight")
    private Set<Ticket> tickets;
}

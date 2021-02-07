package com.finartz.flightticket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finartz.flightticket.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"flight"})
@ToString(exclude = {"flight"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ticket extends BaseEntity {
    private Long id;
    private String pnrNo;

    @JsonIgnore
    @ManyToOne
    private Flight flight;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
}

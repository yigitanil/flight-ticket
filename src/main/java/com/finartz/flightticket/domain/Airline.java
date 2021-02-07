package com.finartz.flightticket.domain;

import com.finartz.flightticket.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Airline extends BaseEntity {

    private String airlineName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "airline")
    private Set<Flight> flights;
}

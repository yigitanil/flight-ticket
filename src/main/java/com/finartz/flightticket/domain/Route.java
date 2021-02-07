package com.finartz.flightticket.domain;

import com.finartz.flightticket.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Route extends BaseEntity {

    @OneToOne
    private Airport departureLine;

    @OneToOne
    private Airport arrivalLine;
}

package com.finartz.flightticket.domain;

import com.finartz.flightticket.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Airport extends BaseEntity {
    private Long id;
    private String airportName;
}

package com.finartz.flightticket.domain;

import com.finartz.flightticket.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Payment extends BaseEntity {
    private Long id;

    private String creditCardNumber;
}

package com.finartz.flightticket.domain.base;

import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt=LocalDateTime.now();
        updatedAt=createdAt;
    }
    @PreUpdate
    public void preUpdate(){
        updatedAt=LocalDateTime.now();
    }

}

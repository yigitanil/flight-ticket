package com.finartz.flightticket.service;

import com.finartz.flightticket.web.model.RotaDto;

import java.util.List;

public interface RotaService {
    RotaDto getRotaById(Long id);

    List<RotaDto> getAllRotas();

    RotaDto saveRota(RotaDto rotaDto);
}

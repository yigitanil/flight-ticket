package com.finartz.flightticket.web.mapper;

import com.finartz.flightticket.domain.Rota;
import com.finartz.flightticket.web.model.RotaDto;
import org.mapstruct.Mapper;

@Mapper
public interface RotaMapper {
    Rota rotaDtoToRota(RotaDto rotaDto);

    RotaDto rotaToRotaDto(Rota rota);
}

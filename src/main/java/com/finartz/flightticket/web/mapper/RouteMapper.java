package com.finartz.flightticket.web.mapper;

import com.finartz.flightticket.domain.Route;
import com.finartz.flightticket.web.model.RouteDto;
import org.mapstruct.Mapper;

@Mapper
public interface RouteMapper {
    Route rotaDtoToRota(RouteDto routeDto);

    RouteDto rotaToRotaDto(Route route);
}

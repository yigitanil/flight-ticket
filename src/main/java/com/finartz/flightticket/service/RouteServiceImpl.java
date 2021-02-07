package com.finartz.flightticket.service;

import com.finartz.flightticket.domain.Route;
import com.finartz.flightticket.repository.RouteRepository;
import com.finartz.flightticket.web.exception.FlightException;
import com.finartz.flightticket.web.mapper.RouteMapper;
import com.finartz.flightticket.web.model.RouteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    @Override
    public RouteDto getRouteById(Long id) {
        return routeMapper.rotaToRotaDto(routeRepository.findById(id)
                .orElseThrow(() -> new FlightException("Route could not be found.")));
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::rotaToRotaDto)
                .collect(Collectors.toList());
    }

    @Override
    public RouteDto saveRoute(RouteDto routeDto) {
        Optional<Route> rota = routeRepository.findById(routeDto.getId());
        if (rota.isPresent()){
            throw new FlightException("Route is already exist.");
        }

        return routeMapper.rotaToRotaDto(routeRepository
                .save(routeMapper.rotaDtoToRota(routeDto)));
    }
}

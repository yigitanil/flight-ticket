package com.finartz.flightticket.service;

import com.finartz.flightticket.domain.Rota;
import com.finartz.flightticket.repository.RotaRepository;
import com.finartz.flightticket.web.exception.FlightException;
import com.finartz.flightticket.web.mapper.RotaMapper;
import com.finartz.flightticket.web.model.RotaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RotaServiceImpl implements RotaService {
    private final RotaRepository rotaRepository;
    private final RotaMapper rotaMapper;

    @Override
    public RotaDto getRotaById(Long id) {
        return rotaMapper.rotaToRotaDto(rotaRepository.findById(id)
                .orElseThrow(() -> new FlightException("Rota could not be found.")));
    }

    @Override
    public List<RotaDto> getAllRotas() {
        return rotaRepository.findAll()
                .stream()
                .map(rotaMapper::rotaToRotaDto)
                .collect(Collectors.toList());
    }

    @Override
    public RotaDto saveRota(RotaDto rotaDto) {
        Optional<Rota> rota = rotaRepository.findById(rotaDto.getId());
        if (rota.isPresent()){
            throw new FlightException("Rota is already exist.");
        }

        return rotaMapper.rotaToRotaDto(rotaRepository
                .save(rotaMapper.rotaDtoToRota(rotaDto)));
    }
}

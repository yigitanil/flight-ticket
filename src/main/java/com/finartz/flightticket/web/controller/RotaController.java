package com.finartz.flightticket.web.controller;

import com.finartz.flightticket.service.RotaService;
import com.finartz.flightticket.web.model.RotaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rotas")
public class RotaController {
    private final RotaService rotaService;

    @GetMapping("/{id}")
    public RotaDto getRota(@PathVariable Long id){
        return rotaService.getRotaById(id);
    }

    @GetMapping
    public List<RotaDto> getAllRotas(){
        return rotaService.getAllRotas();
    }

    @PostMapping
    public RotaDto saveRota(@RequestBody RotaDto rotaDto) {
        return rotaService.saveRota(rotaDto);
    }
}

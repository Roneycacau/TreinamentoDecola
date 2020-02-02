package com.DBFirst.projetoEventos.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.DBFirst.projetoEventos.domain.dto.response.StatusEventoResponse;
import com.DBFirst.projetoEventos.mapper.StatusEventoMapper;
import com.DBFirst.projetoEventos.service.StatusEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Status")
public class StatusEventController {

    private final StatusEventoService statusEventoService;
    private final StatusEventoMapper statusEventoMapper;

    @Autowired
    public StatusEventController(StatusEventoService statusEventoService, StatusEventoMapper statusEventoMapper) {
        this.statusEventoService = statusEventoService;
        this.statusEventoMapper = statusEventoMapper;
    }

    @GetMapping
    public ResponseEntity<List<StatusEventoResponse>> list() {
        return ResponseEntity.ok(statusEventoService.listStatus().stream() //
                .map(x -> statusEventoMapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StatusEventoResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(statusEventoMapper.toDto(statusEventoService.findById(id)));
    }

}
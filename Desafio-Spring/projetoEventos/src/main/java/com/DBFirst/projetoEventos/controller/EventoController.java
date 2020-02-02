package com.DBFirst.projetoEventos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.DBFirst.projetoEventos.domain.dto.request.EventoRequest;
import com.DBFirst.projetoEventos.domain.dto.response.EventoResponse;
import com.DBFirst.projetoEventos.domain.dto.response.EventoResponseById;
import com.DBFirst.projetoEventos.domain.entities.Evento;
import com.DBFirst.projetoEventos.mapper.EventoMapper;
import com.DBFirst.projetoEventos.service.CategoriaEventoService;
import com.DBFirst.projetoEventos.service.EventoService;
import com.DBFirst.projetoEventos.service.StatusEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EventoController {

    private final EventoService eventoService;
    private final EventoMapper eventoMapper;
    private final StatusEventoService statusEventoService;
    private final CategoriaEventoService categoriaEventoService;

    @Autowired
    public EventoController(EventoService eventoService, EventoMapper eventoMapper,
            StatusEventoService statusEventoService, CategoriaEventoService categoriaEventoService) {
        this.eventoService = eventoService;
        this.eventoMapper = eventoMapper;
        this.categoriaEventoService = categoriaEventoService;
        this.statusEventoService = statusEventoService;
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<EventoResponse>> list() {
        return ResponseEntity.ok(eventoService.listEventos().stream() //
                .map(x -> eventoMapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    // @GetMapping(value = "eventos/{id}")
    // public ResponseEntity<EventoResponseById> getById(@PathVariable Integer id) {
    // return ResponseEntity.ok(eventoMapper.toDto(eventoService.findById(id),
    // eventoService.listParticipants(id)));
    // }
    @GetMapping(value = "eventos/{id}")
    public ResponseEntity<EventoResponseById> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(eventoService.listEvenDetails(id));
    }

    @GetMapping(value = "/eventos/categoria/{id}")
    public ResponseEntity<List<EventoResponse>> listarCategoria(@Valid @RequestBody @PathVariable Integer id) {
        return ResponseEntity.ok(eventoService.lisByCategoria(id).stream() //
                .map(x -> eventoMapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @PostMapping("/eventos")
    public ResponseEntity<EventoResponse> postEvento(@Valid @RequestBody EventoRequest model) {
        Evento evento = (eventoMapper.fromDto(model));
        evento.setStatus(statusEventoService.findById(1));
        evento.setCategoria(categoriaEventoService.findById(model.getCategoria()));
        return ResponseEntity.ok(eventoMapper.toDto(eventoService.createEvent(evento)));
    }

    @PutMapping(value = "eventos/{id}")
    public ResponseEntity<EventoResponse> putEvento(@PathVariable Integer id, @RequestBody EventoRequest entity) {
        Evento model = eventoMapper.fromDto(entity);
        model.setId(id);
        model.setCategoria(categoriaEventoService.findById(entity.getCategoria()));
        return ResponseEntity.ok(eventoMapper.toDto(eventoService.updatEvento(model)));
    }

    @DeleteMapping(value = "eventos/{id}")
    public ResponseEntity<EventoResponse> deleteEvento(@PathVariable Integer id) {
        return ResponseEntity.ok(eventoMapper.toDto(eventoService.deleteEvento(id)));
    }

    @PutMapping(value = "eventos/{id}/iniciar")
    public ResponseEntity<EventoResponse> startEvento(@PathVariable Integer id) {
        return ResponseEntity.ok(eventoMapper.toDto(eventoService.startEvento(id)));
    }

    @PutMapping(value = "eventos/{id}/terminar")
    public ResponseEntity<EventoResponse> endEvento(@PathVariable Integer id) {
        return ResponseEntity.ok(eventoMapper.toDto(eventoService.endEvento(id)));
    }

}
package com.DBFirst.projetoEventos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.DBFirst.projetoEventos.domain.dto.request.ParticipacaoRequest;
import com.DBFirst.projetoEventos.domain.dto.response.ParticipacaoResponse;
import com.DBFirst.projetoEventos.domain.entities.Evento;
import com.DBFirst.projetoEventos.domain.entities.Participacao;
import com.DBFirst.projetoEventos.mapper.ParticipacaoMapper;
import com.DBFirst.projetoEventos.service.EventoService;
import com.DBFirst.projetoEventos.service.ParticipacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/")
public class ParticipacaoController {

    private final ParticipacaoService participacaoService;
    private final ParticipacaoMapper participacaoMapper;

    private final EventoService eventoService;

    @Autowired
    public ParticipacaoController(ParticipacaoService participacaoService, ParticipacaoMapper participacaoMapper,
            EventoService eventoService) {
        this.participacaoService = participacaoService;
        this.participacaoMapper = participacaoMapper;
        this.eventoService = eventoService;
    }

    @GetMapping("/participacao")
    public ResponseEntity<List<ParticipacaoResponse>> list() {
        return ResponseEntity.ok(participacaoService.listParticipantes().stream() //
                .map(x -> participacaoMapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @PostMapping("/eventos/{id}/participar")
    public ResponseEntity<ParticipacaoResponse> postParticipacao(@Valid @RequestBody ParticipacaoRequest model,
            @PathVariable Integer id) throws Throwable {
        Evento event = eventoService.findById(id);
        Participacao participacao = (participacaoMapper.fromDto(model));
        participacao.setEvento(event);
        return ResponseEntity.ok(participacaoMapper.toDto(participacaoService.joinEvent(participacao)));
    }

}
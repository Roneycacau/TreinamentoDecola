package com.DBFirst.projetoEventos.mapper;

import java.util.List;

import com.DBFirst.projetoEventos.domain.dto.request.EventoRequest;
import com.DBFirst.projetoEventos.domain.dto.response.EventoResponse;
import com.DBFirst.projetoEventos.domain.entities.Evento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public EventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public EventoResponse toDto(Evento input) {
        return mapper.map(input, EventoResponse.class);
    }

    public EventoResponse toDto(List<Evento> input) {
        return mapper.map(input, EventoResponse.class);
    }

    public Evento fromDto(EventoRequest model) {
        return mapper.map(model, Evento.class);
    }
}
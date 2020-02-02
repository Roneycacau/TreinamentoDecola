package com.DBFirst.projetoEventos.mapper;

import com.DBFirst.projetoEventos.domain.dto.response.StatusEventoResponse;
import com.DBFirst.projetoEventos.domain.entities.StatusEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusEventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public StatusEventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public StatusEventoResponse toDto(StatusEvento input) {
        return mapper.map(input, StatusEventoResponse.class);
    }

}
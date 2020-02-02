package com.DBFirst.projetoEventos.mapper;

import com.DBFirst.projetoEventos.domain.dto.response.CategoriaEventoResponse;
import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoriaEventoMapper {

    private final ModelMapper mapper;

    @Autowired
    public CategoriaEventoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public CategoriaEventoResponse toDto(CategoriaEvento input) {
        return mapper.map(input, CategoriaEventoResponse.class);
    }

}
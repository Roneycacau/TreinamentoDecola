package com.DBFirst.projetoEventos.mapper;

import com.DBFirst.projetoEventos.domain.dto.request.ParticipacaoRequest;
import com.DBFirst.projetoEventos.domain.dto.response.ParticipacaoResponse;
import com.DBFirst.projetoEventos.domain.entities.Participacao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParticipacaoMapper {

    private final ModelMapper mapper;

    @Autowired
    public ParticipacaoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ParticipacaoResponse toDto(Participacao input) {
        return mapper.map(input, ParticipacaoResponse.class);
    }

    public Participacao fromDto(ParticipacaoRequest model) {
        return mapper.map(model, Participacao.class);
    }
}
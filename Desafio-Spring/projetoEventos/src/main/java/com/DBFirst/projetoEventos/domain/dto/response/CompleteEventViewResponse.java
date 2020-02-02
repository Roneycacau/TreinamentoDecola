package com.DBFirst.projetoEventos.domain.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class CompleteEventViewResponse {
    private EventoResponse evento;
    private List<ParticipacaoResponse> participantes;
}
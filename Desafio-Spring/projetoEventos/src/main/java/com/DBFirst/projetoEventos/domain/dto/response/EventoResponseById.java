package com.DBFirst.projetoEventos.domain.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoResponseById {
    private EventoResponse evento;
    private List<String> participantes;
}
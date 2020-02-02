package com.DBFirst.projetoEventos.domain.dto.response;

import com.DBFirst.projetoEventos.domain.entities.Evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoResponse {

    private Integer id;
    private Evento evento;
    private String login;
    private Boolean presente;
    private Integer nota;
    private String comentario;
}
package com.DBFirst.projetoEventos.domain.dto.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipacaoRequest {

    @NotNull(message = "Evento não pode ser null")
    // int evento;
    private String login;
    // private boolean presente;
    // private int nota;
    // private String comentario;
}
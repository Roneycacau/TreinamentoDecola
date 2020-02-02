package com.DBFirst.projetoEventos.domain.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoResponse {
    private Integer id;
    private StatusEventoResponse status;
    private CategoriaEventoResponse categoria;
    private String nome;
    private Date inicio;
    private Date fim;
    private String local;
    private String descricao;
    private Integer vagas;
}
package com.DBFirst.projetoEventos.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StatusEventoResponse {

    private Integer id;
    private String status;
}
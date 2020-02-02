package com.DBFirst.projetoEventos.domain.dto.request;

import java.util.Date;
import com.DBFirst.projetoEventos.domain.validators.DataFimGreaterThanInicio;
import com.DBFirst.projetoEventos.domain.validators.InicioFimSameDay;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DataFimGreaterThanInicio
@InicioFimSameDay
public class EventoRequest {

    // @NotNull(message = "Status não pode ser null")
    // int status;

    @NotNull(message = "Categoria não pode ser null")
    private Integer categoria;

    @NotEmpty(message = "Nome precisa ser preenchido")
    private String nome;

    @NotNull(message = "Informe uma data válida (yyyy-MM-DDTHH:mm:ss)")
    @Future(message = "Data de início não pode ser no passado")
    private Date inicio;

    @NotNull(message = "Informe uma data válida (yyyy-MM-DDTHH:mm:ss)")
    private Date fim;

    @NotEmpty(message = "Local precisa ser preenchido")
    private String local;

    @NotEmpty(message = "Descrição precisa ser preenchido")
    private String descricao;

    @NotNull(message = "Vaga precisa ser preenchido")
    private Integer vagas;
}
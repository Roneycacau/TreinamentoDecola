package com.DBFirst.projetoEventos.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEvento")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdEventoStatus", nullable = false)
    private StatusEvento status;

    @ManyToOne
    @JoinColumn(name = "IdCategoriaEvento", nullable = false)
    private CategoriaEvento categoria;

    @Column(nullable = false, length = 250, name = "Nome")
    private String nome;

    @Column(nullable = false, name = "DataHoraInicio", columnDefinition = "DATETIME")
    private Date inicio;

    @Column(nullable = false, length = 250, name = "DataHoraFim", columnDefinition = "DATETIME")
    private Date fim;

    @Column(nullable = false, length = 250, name = "Local")
    private String local;

    @Column(nullable = false, length = 1000, name = "Descricao")
    private String descricao;

    @Column(nullable = false, name = "LimiteVagas")
    private Integer vagas;
}
package com.DBFirst.projetoEventos.domain.entities;

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
@Table(name = "Participacao")
public class Participacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdParticipacao")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdEvento", nullable = false)
    private Evento evento;

    @Column(nullable = false, length = 250, name = "LoginParticipante")
    private String login;

    @Builder.Default
    @Column(nullable = false, name = "FlagPresente")
    private Boolean presente = false;

    @Column(nullable = true, name = "Nota")
    private Integer nota;

    @Column(length = 1000, name = "Comentario")
    private String comentario;
}
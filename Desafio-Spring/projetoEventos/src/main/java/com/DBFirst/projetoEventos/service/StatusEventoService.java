package com.DBFirst.projetoEventos.service;

import java.util.List;
import java.util.Optional;

import com.DBFirst.projetoEventos.domain.entities.StatusEvento;
import com.DBFirst.projetoEventos.exeption.DataNotFoundException;
import com.DBFirst.projetoEventos.repository.StatusEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StatusEventoService {

    private final StatusEventoRepository statusEventoRepository;

    @Autowired
    public StatusEventoService(StatusEventoRepository statusEventoRepository) {
        this.statusEventoRepository = statusEventoRepository;
    }

    public List<StatusEvento> listStatus() {
        return statusEventoRepository.findAll();
    }

    public StatusEvento findById(Integer id) {
        Optional<StatusEvento> status = statusEventoRepository.findById(id);
        return status.orElseThrow(() -> new DataNotFoundException("Status não encontrado"));
    }

}
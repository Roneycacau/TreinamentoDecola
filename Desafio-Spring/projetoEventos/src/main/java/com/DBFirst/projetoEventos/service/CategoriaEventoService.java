package com.DBFirst.projetoEventos.service;

import java.util.List;
import java.util.Optional;

import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.exeption.DataNotFoundException;
import com.DBFirst.projetoEventos.repository.CategoriaEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoriaEventoService {

    private final CategoriaEventoRepository categoriaEventoRepository;

    @Autowired
    public CategoriaEventoService(CategoriaEventoRepository categoriaEventoRepository) {
        this.categoriaEventoRepository = categoriaEventoRepository;
    }

    public List<CategoriaEvento> listCategorias() {
        return categoriaEventoRepository.findAll();
    }

    public CategoriaEvento findById(Integer id) {
        Optional<CategoriaEvento> status = categoriaEventoRepository.findById(id);
        return status.orElseThrow(() -> new DataNotFoundException("Categoria não encontrada"));
    }

}
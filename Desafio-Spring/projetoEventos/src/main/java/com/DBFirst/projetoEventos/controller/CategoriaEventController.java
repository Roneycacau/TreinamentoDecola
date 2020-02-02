package com.DBFirst.projetoEventos.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.DBFirst.projetoEventos.domain.dto.response.CategoriaEventoResponse;
import com.DBFirst.projetoEventos.mapper.CategoriaEventoMapper;
import com.DBFirst.projetoEventos.service.CategoriaEventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Categorias")
public class CategoriaEventController {

    private final CategoriaEventoService categoriaEventoService;
    private final CategoriaEventoMapper categoriaEventoMapper;

    @Autowired
    public CategoriaEventController(CategoriaEventoService categoriaEventoService,
            CategoriaEventoMapper categoriaEventoMapper) {
        this.categoriaEventoService = categoriaEventoService;
        this.categoriaEventoMapper = categoriaEventoMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaEventoResponse>> list() {
        return ResponseEntity.ok(categoriaEventoService.listCategorias().stream() //
                .map(x -> categoriaEventoMapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEventoResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaEventoMapper.toDto(categoriaEventoService.findById(id)));
    }

}
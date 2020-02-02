package com.DBFirst.projetoEventos.repository;

import java.util.List;

import com.DBFirst.projetoEventos.domain.entities.StatusEvento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StatusEventoRepository extends JpaRepository<StatusEvento, Integer> {
    @Query(nativeQuery = true, value = "select distinct name from CategoriaEvento")
    List<String> listDistinct();
}
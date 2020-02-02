package com.DBFirst.projetoEventos.repository;

import java.util.List;

import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.domain.entities.Evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @Query(nativeQuery = true, value = "select distinct name from Evento")
    List<String> listDistinct();

    @Query(nativeQuery = true, value = "SELECT p.LoginParticipante FROM dbo.Participacao as P WHERE p.IdEvento = :idEvento")
    List<String> listParticipants(Integer idEvento);

    // @Query(nativeQuery = true, value = "SELECT [IdEvento] ,[IdEventoStatus]
    // ,[IdCategoriaEvento] ,[Nome] ,[DataHoraInicio] ,[DataHoraFim] ,[Local]
    // ,[Descricao] ,[LimiteVagas] FROM [projetoEventos].[dbo].[Evento] WHERE
    // IdCategoriaEvento = :categoria")
    // List<EventoResponse> findByCategoria(int categoria);

    @Query(nativeQuery = true, value = "SELECT e.IdEvento,e.Nome,e.IdEventoStatus,e.Descricao,e.[Local],e.IdCategoriaEvento,e.DataHoraInicio,e.DataHoraFim,e.LimiteVagas FROM [projetoEventos].[dbo].[Evento] AS E WHERE e.IdCategoriaEvento= :id")
    List<Evento> listCategorias(Integer id);

    List<Evento> findByCategoria(CategoriaEvento categoria);
}
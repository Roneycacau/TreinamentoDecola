package com.DBFirst.projetoEventos.repository;

import java.util.List;

import com.DBFirst.projetoEventos.domain.entities.Participacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {

    @Query(nativeQuery = true, value = "select distinct login from Participacao")
    List<String> listDistinct();

    @Query(nativeQuery = true, value = "SELECT  COUNT(p.[LoginParticipante]) AS [Quantidade de participantes] FROM [projetoEventos].[dbo].[Participacao] AS P WHERE P.IdEvento = :idEvento")
    int countParticipants(Integer idEvento);

}
package com.DBFirst.projetoEventos.domain.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.DBFirst.projetoEventos.configuration.MapperConfig;
import com.DBFirst.projetoEventos.domain.dto.request.ParticipacaoRequest;
import com.DBFirst.projetoEventos.domain.dto.response.ParticipacaoResponse;
import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.domain.entities.Evento;
import com.DBFirst.projetoEventos.domain.entities.Participacao;
import com.DBFirst.projetoEventos.domain.entities.StatusEvento;
import com.DBFirst.projetoEventos.mapper.ParticipacaoMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoMapperTest {

    @Mock
    private CategoriaEvento categoria;
    private StatusEvento status;
    private Evento evento;

    @Before
    public void setUp() {
        categoria = CategoriaEvento.builder().id(1).categoria("categoria").build();
        status = StatusEvento.builder().id(1).status("status").build();
        evento = Evento.builder().id(1).status(status).categoria(categoria).nome("nome").descricao("descricao")
                .inicio(new Date()).fim(new Date()).local("local").vagas(10).build();
    }

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private ParticipacaoMapper mapper;

    @Test
    public void shouldConvertParticipacaoToParticipacaoResponse() {
        // given
        Participacao entity = Participacao.builder().evento(evento).id(1).login("login").comentario("comentario")
                .nota(5).presente(true).build();

        // when
        ParticipacaoResponse dto = mapper.toDto(entity);

        // then

        assertEquals("Unexpected value found!", dto.getEvento(), entity.getEvento());
        assertEquals("Unexpected value found!", dto.getId(), entity.getId());
        assertEquals("Unexpected value found!", dto.getLogin(), entity.getLogin());
        assertEquals("Unexpected value found!", dto.getComentario(), entity.getComentario());
        assertEquals("Unexpected value found!", dto.getNota(), entity.getNota());
        assertEquals("Unexpected value found!", dto.getPresente(), entity.getPresente());
    }

    @Test
    public void shouldConvertParticipacaoCreateRequestToParticipacao() {
        ParticipacaoRequest dto = ParticipacaoRequest.builder().login("login").build();

        Participacao entity = mapper.fromDto(dto);

        assertEquals("Unexpected value found!", dto.getLogin(), entity.getLogin());
    }

}
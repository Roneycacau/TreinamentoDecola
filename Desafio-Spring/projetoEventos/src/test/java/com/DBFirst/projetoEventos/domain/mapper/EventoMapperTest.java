package com.DBFirst.projetoEventos.domain.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DBFirst.projetoEventos.configuration.MapperConfig;
import com.DBFirst.projetoEventos.domain.dto.request.EventoRequest;
import com.DBFirst.projetoEventos.domain.dto.response.EventoResponse;
import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.domain.entities.Evento;
import com.DBFirst.projetoEventos.domain.entities.StatusEvento;
import com.DBFirst.projetoEventos.mapper.EventoMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class EventoMapperTest {

    @Mock
    private CategoriaEvento categoria;
    private StatusEvento status;

    @Before
    public void setUp() {
        categoria = CategoriaEvento.builder().id(1).categoria("categoria").build();
        status = StatusEvento.builder().id(1).status("status").build();
    }

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private EventoMapper mapper;

    @Test
    public void shouldConvertEventoToEventoResponse() {
        // given
        Evento entity = Evento.builder().id(1).status(status).categoria(categoria).nome("nome").descricao("descricao")
                .inicio(new Date()).fim(new Date()).local("local").vagas(10).build();
        // when
        EventoResponse dto = mapper.toDto(entity);

        // then
        assertEquals("Unexpected value found!", dto.getId(), entity.getId());
        assertEquals("Unexpected value found!", dto.getStatus().getId(), entity.getStatus().getId());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
        assertEquals("Unexpected value found!", dto.getCategoria().getId(), entity.getCategoria().getId());
        assertEquals("Unexpected value found!", dto.getDescricao(), entity.getDescricao());
        assertEquals("Unexpected value found!", dto.getInicio(), entity.getInicio());
        assertEquals("Unexpected value found!", dto.getFim(), entity.getFim());
        assertEquals("Unexpected value found!", dto.getLocal(), entity.getLocal());
        assertEquals("Unexpected value found!", dto.getVagas(), entity.getVagas());
    }

    @Test
    public void shouldConvertEventoRequesttoEvento() {
        EventoRequest dto = EventoRequest.builder().categoria(1).nome("nome").descricao("descricao").local("local")
                .inicio(new Date()).fim(new Date()).vagas(10).build();

        Evento entity = mapper.fromDto(dto);
        entity.setCategoria(categoria);
        entity.setStatus(status);

        assertEquals("Unexpected value found!", dto.getCategoria(), entity.getCategoria().getId());
        assertEquals("Unexpected value found!", dto.getDescricao(), entity.getDescricao());
        assertEquals("Unexpected value found!", dto.getLocal(), entity.getLocal());
        assertEquals("Unexpected value found!", dto.getInicio(), entity.getInicio());
        assertEquals("Unexpected value found!", dto.getFim(), entity.getFim());
        assertEquals("Unexpected value found!", dto.getVagas(), entity.getVagas());
        assertEquals("Unexpected value found!", dto.getNome(), entity.getNome());
    }

    @Test
    public void should_ListEventos() {
        List<Evento> list = new ArrayList<Evento>();
        Evento entity = Evento.builder().id(1).status(status).categoria(categoria).nome("nome").descricao("descricao")
                .inicio(new Date()).fim(new Date()).local("local").vagas(10).build();
        list.add(entity);
        EventoResponse dto = mapper.toDto(list);

    }
}
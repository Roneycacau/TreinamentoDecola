package com.DBFirst.projetoEventos.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.domain.entities.Evento;
import com.DBFirst.projetoEventos.domain.entities.Participacao;
import com.DBFirst.projetoEventos.domain.entities.StatusEvento;
import com.DBFirst.projetoEventos.exeption.BusinessRuleFail;
import com.DBFirst.projetoEventos.repository.ParticipacaoRepository;
import com.DBFirst.projetoEventos.service.ParticipacaoService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ParticipacaoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private ParticipacaoRepository repositoryMock;

    @InjectMocks
    private ParticipacaoService service;

    private final Integer id = 1;

    CategoriaEvento categoria = CategoriaEvento.builder().id(id).categoria("categoria").build();
    StatusEvento status = StatusEvento.builder().id(id).status("status").build();
    Evento evento = Evento.builder().id(1).status(status).categoria(categoria)//
            .nome("nome").descricao("descricao").inicio(new Date())//
            .fim(new Date()).local("local").vagas(1).build();

    Participacao entity = Participacao.builder().id(id).evento(evento).login("login").build();

    @Test
    public void should_ListOneItem() {
        List<Participacao> list = new ArrayList<>();
        list.add(entity);
        // given
        when(repositoryMock.findAll()).thenReturn(list);
        // when
        List<Participacao> listR = service.listParticipantes();
        // then
        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

    @Test
    public void shold_JoinEvent() throws Throwable {
        when(repositoryMock.save(entity)).thenReturn(entity);
        Participacao model = service.joinEvent(entity);
        verify(repositoryMock, times(1)).save(entity);
        assertNotNull(model);
    }

    @Test(expected = BusinessRuleFail.class)
    public void shold_Fail_JoinEvent_WithoutVagas() throws Throwable {
        lenient().when(repositoryMock.countParticipants(entity.getEvento().getId())).thenReturn(10);
        lenient().when(repositoryMock.save(entity)).thenReturn(entity);
        Participacao model = service.joinEvent(entity);
        verify(repositoryMock, times(1)).save(entity);
        assertNotNull(model);
        expected.expectMessage("Todas as vagas já foram preenchidas");
    }

    @Test(expected = BusinessRuleFail.class)
    public void shold_Fail_JoinEvent_WhenStatusNotOpen() throws Throwable {
        StatusEvento status = StatusEvento.builder().id(2).status("status").build();
        Evento evento = Evento.builder()//
                .id(1)//
                .status(status)//
                .categoria(categoria)//
                .nome("nome").descricao("descricao").inicio(new Date())//
                .fim(new Date()).local("local").vagas(1).build();
        Participacao entity = Participacao.builder().id(id).evento(evento).login("login").build();

        lenient().when(repositoryMock.save(entity)).thenReturn(entity);
        Participacao model = service.joinEvent(entity);
        verify(repositoryMock, times(1)).save(entity);
        assertNotNull(model);
        expected.expectMessage("Só é possivel se inscrever se o evento estiver aguardando inscrição");
    }

}
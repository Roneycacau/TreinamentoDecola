package com.DBFirst.projetoEventos.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.domain.entities.Evento;
import com.DBFirst.projetoEventos.domain.entities.StatusEvento;
import com.DBFirst.projetoEventos.exeption.DataNotFoundException;
import com.DBFirst.projetoEventos.repository.EventoRepository;
import com.DBFirst.projetoEventos.service.EventoService;
import com.DBFirst.projetoEventos.service.StatusEventoService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private EventoRepository repositoryMock;
    @Mock
    private StatusEventoService eventoStatusService;

    @InjectMocks
    private EventoService service;

    private final Integer id = 1;
    private Calendar cal = Calendar.getInstance();
    private Calendar calInicio = Calendar.getInstance();
    private Calendar calFim = Calendar.getInstance();
    private final Date inicio = ini();
    private final Date fim = fi();

    private Date ini() {
        this.calInicio.set(2020, 2, 20, 15, 00);
        return calInicio.getTime();
    }

    private Date fi() {
        this.calFim.set(2020, 2, 20, 17, 00);
        return calFim.getTime();
    }

    CategoriaEvento categoria = CategoriaEvento.builder().id(1).categoria("categoria").build();
    StatusEvento status = StatusEvento.builder().id(1).status("status").build();
    StatusEvento statusCancel = StatusEvento.builder().id(4).status("status").build();
    Evento entity = Evento.builder()//
            .id(1)//
            .status(status)//
            .categoria(categoria)//
            .nome("nome")//
            .descricao("descricao")//
            .inicio(inicio)//
            .fim(fim)//
            .local("local")//
            .vagas(10)//
            .build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {
        // given no data
        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Evento não encontrado");
        // when
        service.findById(id);
    }

    @Test
    public void should_findById() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        Evento model = service.findById(anyInt());
        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Evento não encontrado", model);
    }

    @Test
    public void should_ListOneItem() {
        List<Evento> list = new ArrayList<>();
        list.add(entity);
        // given
        when(repositoryMock.findAll()).thenReturn(list);
        // when
        List<Evento> listR = service.listEventos();
        // then
        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

    @Test
    public void should_CreateEvento() {
        when(repositoryMock.save(entity)).thenReturn(entity);
        Evento model = service.createEvent(entity);
        verify(repositoryMock, times(1)).save(entity);
        assertNotNull(model);
    }

    @Test
    public void should_UpdateEvento() {
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        when(repositoryMock.save(entity)).thenReturn(entity);
        Evento model = Evento.builder()//
                .id(1)//
                .status(status)//
                .categoria(categoria)//
                .nome("nome")//
                .descricao("descricao")//
                .inicio(inicio)//
                .fim(fim)//
                .local("local")//
                .vagas(10)//
                .build();
        Evento event = service.updatEvento(service.findById(anyInt()));
        assertEquals(event, model);
        verify(repositoryMock, times(1)).save(event);
        assertNotNull(model);
    }

    @Test
    public void should_CompareDateEqualsToday() {
        assertTrue(service.compareDateInZeroHour(cal.getTime()));
        assertFalse(!service.compareDateInZeroHour(cal.getTime()));
    }

    // @Test
    // public void should_ChangeStatusToCanceled() {
    // // given / dado / dado de teste
    // when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));

    // Evento event = service.deleteEvento(1);
    // status.setId(4);
    // entity.setStatus(status);
    // Evento model = Evento.builder()//
    // .id(1)//
    // .status(status)//
    // .categoria(categoria)//
    // .nome("nome")//
    // .descricao("descricao")//
    // .inicio(inicio)//
    // .fim(fim)//
    // .local("local")//
    // .vagas(10)//
    // .build();
    // assertEquals(event, model);
    // verify(repositoryMock, times(1)).save(event);
    // // assertNotNull(model);
    // }

    @Test
    public void should_ChangeStatusToCanceled_doug() {
        // given / dado / dado de teste
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        when(eventoStatusService.findById(4)).thenReturn(statusCancel);
        when(repositoryMock.save(any())).thenAnswer(i -> {
            return (Evento) i.getArguments()[0];
        });

        Integer idCancela = 4;

        // when
        Evento event = service.deleteEvento(1);
        event.getStatus().setId(idCancela);
        assertEquals(event.getStatus().getId(), idCancela);
        verify(repositoryMock, times(1)).save(event);
        // assertNotNull(model);
    }

}
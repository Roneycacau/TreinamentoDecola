package com.DBFirst.projetoEventos.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.exeption.DataNotFoundException;
import com.DBFirst.projetoEventos.repository.CategoriaEventoRepository;
import com.DBFirst.projetoEventos.service.CategoriaEventoService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Mock
    private CategoriaEventoRepository repositoryMock;

    @InjectMocks
    private CategoriaEventoService service;

    private final Integer id = 1;
    private final String categoria = "categoria";

    CategoriaEvento entity = CategoriaEvento.builder().id(id).categoria(categoria).build();

    @Test
    public void should_ThrowDataNotFoundException_whenNotFound() {
        // given no data
        // then
        expected.expect(DataNotFoundException.class);
        expected.expectMessage("Categoria não encontrada");
        // when
        service.findById(id);
    }

    @Test
    public void should_findById() {
        // given
        when(repositoryMock.findById(anyInt())).thenReturn(Optional.of(entity));
        // when
        CategoriaEvento model = service.findById(anyInt());
        // then
        verify(repositoryMock, times(1)).findById(anyInt());
        assertNotNull("Client deve ser encontrado!", model);
    }

    @Test
    public void should_ListOneItem() {
        List<CategoriaEvento> list = new ArrayList<>();
        list.add(entity);
        // given
        when(repositoryMock.findAll()).thenReturn(list);
        // when
        List<CategoriaEvento> listR = service.listCategorias();
        // then
        verify(repositoryMock, times(1)).findAll();
        assertNotNull("Array não deve ser nulo", listR);
        assertEquals("Array deve ser de tamanho 1", 1, listR.size());
    }

}
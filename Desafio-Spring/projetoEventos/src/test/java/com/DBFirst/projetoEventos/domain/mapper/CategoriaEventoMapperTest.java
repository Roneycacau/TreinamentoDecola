package com.DBFirst.projetoEventos.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.DBFirst.projetoEventos.configuration.MapperConfig;
import com.DBFirst.projetoEventos.domain.dto.response.CategoriaEventoResponse;
import com.DBFirst.projetoEventos.domain.entities.CategoriaEvento;
import com.DBFirst.projetoEventos.mapper.CategoriaEventoMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

/**
 * ClientMapperTest
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private CategoriaEventoMapper mapper;

    @Test
    public void shouldConvertCategoriaEventoToCategoriaEventoResponse() {
        // given
        CategoriaEvento entity = CategoriaEvento.builder().id(1).categoria("Deitar Racista no Soco").build();

        // when
        CategoriaEventoResponse dto = mapper.toDto(entity);

        // then

        // assertEquals("Unexpected value found!", dto.getId(), entity.getId());
        assertEquals("message", dto.getId(), entity.getId());
        assertEquals("Unexpected value found!", dto.getCategoria(), entity.getCategoria());
    }

}
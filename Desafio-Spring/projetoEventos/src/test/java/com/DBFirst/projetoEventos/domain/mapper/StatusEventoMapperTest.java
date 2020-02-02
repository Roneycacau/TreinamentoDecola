package com.DBFirst.projetoEventos.domain.mapper;

import static org.junit.Assert.assertEquals;

import com.DBFirst.projetoEventos.configuration.MapperConfig;
import com.DBFirst.projetoEventos.domain.dto.response.StatusEventoResponse;
import com.DBFirst.projetoEventos.domain.entities.StatusEvento;
import com.DBFirst.projetoEventos.mapper.StatusEventoMapper;

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
public class StatusEventoMapperTest {

    @Spy
    private ModelMapper modelMapper = new MapperConfig().getModelMapper();

    @InjectMocks
    private StatusEventoMapper mapper;

    @Test
    public void shouldConvertStatusEventoToStatusEventoResponse() {
        // given
        StatusEvento entity = StatusEvento.builder().id(1).status("Aberto").build();

        // when
        StatusEventoResponse dto = mapper.toDto(entity);

        // then

        // assertEquals("Unexpected value found!", dto.getId(), entity.getId());
        assertEquals("message", dto.getId(), entity.getId());
        assertEquals("Unexpected value found!", dto.getStatus(), entity.getStatus());
    }

}
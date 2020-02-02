package com.DBFirst.projetoEventos.domain.validators;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import javax.validation.ConstraintValidatorContext;

import com.DBFirst.projetoEventos.domain.dto.request.EventoRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataFimGreaterThanInicioValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;
    private DataFimGreaterThanInicioValidator dataFimGreaterThanInicio;
    private EventoRequest value;
    private Calendar inicio;
    private Calendar fim;

    @Before
    public void setUp() {
        dataFimGreaterThanInicio = new DataFimGreaterThanInicioValidator();
        value = new EventoRequest();

        inicio = Calendar.getInstance();
        inicio.set(Calendar.MINUTE, 0);
        inicio.add(Calendar.DATE, 1);

        fim = Calendar.getInstance();
        fim.add(Calendar.DATE, 1);

    }

    @Test
    public void should_notNull() {
        value.setFim(fim.getTime());
        value.setInicio(inicio.getTime());
        assertNotNull("Mapper não pode ser null!", dataFimGreaterThanInicio.isValid(value, constraintValidatorContext));
    }

    @Test
    public void shold_InicioLessThanFim() {
        value.setInicio(inicio.getTime());
        value.setFim(fim.getTime());
        assertTrue("fim deve ser maior que inicio",
                dataFimGreaterThanInicio.isValid(value, constraintValidatorContext));
    }

    @Test
    public void shold_NotBeValid_InicioGreaterThanFim() {
        value.setInicio(fim.getTime());
        value.setFim(inicio.getTime());
        assertFalse("fim deve ser maior que inicio",
                dataFimGreaterThanInicio.isValid(value, constraintValidatorContext));
    }

    @Test
    public void shold_NotBeValid_InicioEqualsFim() {
        value.setInicio(fim.getTime());
        value.setFim(fim.getTime());
        assertFalse("fim deve ser maior que inicio",
                dataFimGreaterThanInicio.isValid(value, constraintValidatorContext));
    }

}
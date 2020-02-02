package com.DBFirst.projetoEventos.domain.validators;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;

import javax.validation.ConstraintValidatorContext;

import com.DBFirst.projetoEventos.domain.dto.request.EventoRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InicioFimSameDayValidatorTest {

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;
    private InicioFimSameDayValidator inicioFimSameDayValidator;
    private EventoRequest value;
    private Calendar inicio;
    private Calendar fim;

    @Before
    public void setUp() {
        inicioFimSameDayValidator = new InicioFimSameDayValidator();
        value = new EventoRequest();

        inicio = Calendar.getInstance();
        inicio.set(Calendar.MINUTE, 0);
        inicio.add(Calendar.DATE, 1);

        fim = Calendar.getInstance();
        fim.add(Calendar.DATE, 1);
        value.setInicio(inicio.getTime());
        value.setFim(fim.getTime());

    }

    @Test
    public void should_SameDay() {
        assertTrue(inicioFimSameDayValidator.isValid(value, constraintValidatorContext));
    }

    @Test
    public void should_NotValid_NotSameDay() {
        Calendar plus1 = Calendar.getInstance();
        plus1.setTime(value.getFim());
        plus1.add(Calendar.DAY_OF_MONTH, 1);
        value.setFim(plus1.getTime());
        assertFalse(inicioFimSameDayValidator.isValid(value, constraintValidatorContext));
    }

    @Test
    public void should_NotValid_NotSameMonth() {
        Calendar plus1 = Calendar.getInstance();
        plus1.setTime(value.getFim());
        plus1.add(Calendar.MONTH, 1);
        value.setFim(plus1.getTime());
        assertFalse(inicioFimSameDayValidator.isValid(value, constraintValidatorContext));
    }

    @Test
    public void should_NotValid_NotSameYear() {
        Calendar plus1 = Calendar.getInstance();
        plus1.setTime(value.getFim());
        plus1.add(Calendar.YEAR, 1);
        value.setFim(plus1.getTime());
        assertFalse(inicioFimSameDayValidator.isValid(value, constraintValidatorContext));
    }
}
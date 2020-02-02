package com.DBFirst.projetoEventos.domain.validators;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.DBFirst.projetoEventos.domain.dto.request.EventoRequest;

public class DataFimGreaterThanInicioValidator implements ConstraintValidator<DataFimGreaterThanInicio, EventoRequest> {

    @Override
    public boolean isValid(EventoRequest value, ConstraintValidatorContext context) {
        Calendar zeraMiliInicio = Calendar.getInstance();
        zeraMiliInicio.setTime(value.getInicio());
        zeraMiliInicio.set(Calendar.MILLISECOND, 0);
        Calendar zeraMiliFim = Calendar.getInstance();
        zeraMiliFim.setTime(value.getFim());
        zeraMiliFim.set(Calendar.MILLISECOND, 0);
        return (zeraMiliInicio.getTimeInMillis() < zeraMiliFim.getTimeInMillis());
    }
}
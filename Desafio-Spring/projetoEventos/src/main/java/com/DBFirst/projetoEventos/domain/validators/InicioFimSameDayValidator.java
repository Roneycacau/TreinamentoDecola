package com.DBFirst.projetoEventos.domain.validators;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.DBFirst.projetoEventos.domain.dto.request.EventoRequest;

public class InicioFimSameDayValidator implements ConstraintValidator<InicioFimSameDay, EventoRequest> {

    @Override
    public boolean isValid(EventoRequest value, ConstraintValidatorContext context) {
        Calendar inicio = Calendar.getInstance();
        inicio.setTime(value.getInicio());
        Calendar fim = Calendar.getInstance();
        fim.setTime(value.getFim());
        return ((inicio.get(Calendar.DAY_OF_MONTH) == fim.get(Calendar.DAY_OF_MONTH))
                && inicio.get(Calendar.MONTH) == fim.get(Calendar.MONTH)
                && inicio.get(Calendar.YEAR) == fim.get(Calendar.YEAR));
        // && inicio.getTimeInMillis() < fim.getTimeInMillis());
    }
}
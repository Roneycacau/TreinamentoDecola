package com.DBFirst.projetoEventos.domain.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = InicioFimSameDayValidator.class)
@Documented
public @interface InicioFimSameDay {

    String message() default "Data Fim deve ser no mesmo dia que Data Inicio";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
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
@Constraint(validatedBy = DataFimGreaterThanInicioValidator.class)
@Documented
public @interface DataFimGreaterThanInicio {

    String message() default "Data Fim deve ser maior que Data Inicio";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
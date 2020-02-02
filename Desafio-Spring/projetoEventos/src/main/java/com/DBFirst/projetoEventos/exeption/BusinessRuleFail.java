package com.DBFirst.projetoEventos.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção de aplicação. Indica que algum objeto não foi encontrado. Ao ser
 * lançada na camada controller, causa retorno de erro 404 (Not Found), conforme
 * definido pela anotação @ResponseStatus.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BusinessRuleFail extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -6754767023122935455L;

    public BusinessRuleFail(String message) {
        super(message);
    }

    public BusinessRuleFail(String message, Throwable e) {
        super(message, e);
    }
}
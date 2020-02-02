package com.DBFirst.projetoEventos.domain.exeption;

import com.DBFirst.projetoEventos.exeption.DataNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

/**
 * ClientServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class DataNotFoundExceptionTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test(expected = DataNotFoundException.class)
    public void should_DataNotFoundExceptionException() {
        throw new DataNotFoundException("Mensagem");
    }

    @Test(expected = DataNotFoundException.class)
    public void should_DataNotFoundExceptionException2() {
        Throwable e = new Throwable();
        throw new DataNotFoundException("Mensagem", e);
    }
}
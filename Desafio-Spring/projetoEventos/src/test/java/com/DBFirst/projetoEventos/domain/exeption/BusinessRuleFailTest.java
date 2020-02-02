package com.DBFirst.projetoEventos.domain.exeption;

import com.DBFirst.projetoEventos.exeption.BusinessRuleFail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

/**
 * ClientServiceTest
 */
@RunWith(MockitoJUnitRunner.class)
public class BusinessRuleFailTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test(expected = BusinessRuleFail.class)
    public void should_BusinessRuleFailException() {
        throw new BusinessRuleFail("Mensagem");
    }

    @Test(expected = BusinessRuleFail.class)
    public void should_BusinessRuleFailException2() {
        Throwable e = new Throwable();
        throw new BusinessRuleFail("Mensagem", e);
    }
}
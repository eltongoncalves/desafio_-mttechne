package com.mttech.lancamentos.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreditoTest {

    private Credito credito = new Credito();

    @Test
    public void valorCreditoNaoPodeSerZeroDeveRetornarException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            credito.setValor(0.0);
        });
        String expectedMessage = "O valor do crédito não pode ser menor ou igual a zero";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}

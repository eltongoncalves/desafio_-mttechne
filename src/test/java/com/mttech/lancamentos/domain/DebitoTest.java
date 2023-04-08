package com.mttech.lancamentos.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DebitoTest {

    private Debito debito = new Debito();

    @Test
    public void valorCreditoNaoPodeSerZeroDeveRetornarException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            debito.setValor(0.0);
        });
        String expectedMessage = "O valor do débito não pode ser menor ou igual a zero";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}

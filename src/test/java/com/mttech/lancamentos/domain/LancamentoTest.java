package com.mttech.lancamentos.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LancamentoTest {

    private Lancamento lancamento = new Lancamento();

    @Test
    public void descricaoNaoPodeSerVazisDeveRetornarException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            lancamento.setDescricao("");
        });
        String expectedMessage = "A descricão é obrigatório";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}

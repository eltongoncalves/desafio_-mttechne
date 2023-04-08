package com.mttech.lancamentos.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class LancamentoImplementTest {

    @InjectMocks
    private LancamentoImplement lancamentoImplement;

    @Test
    public void deveIncrementarSaldoComValorLancado() throws Exception {
        Credito credito = lancamentoImplement.lancarCredito("descricao", 1.0, 1.0);
        assertTrue(credito.getSaldo().equals(2.0));
    }

    @Test
    public void deveDecrementarSaldoComValorLancado() throws Exception {
        Debito debito = lancamentoImplement.lancarDebito("descricao", 1.0, 2.0);
        assertTrue(debito.getSaldo().equals(1.0));
    }
}

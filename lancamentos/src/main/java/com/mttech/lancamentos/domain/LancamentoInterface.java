package com.mttech.lancamentos.domain;

public interface LancamentoInterface {
    Credito lancarCredito(String descricao, Double valor, Double saldoAtua) throws Exception;
    Debito lancarDebito(String descricao, Double valor, Double saldoAtua) throws Exception;
}

package com.mttech.lancamentos.domain;

public interface LancamentoCreditoInterface {

    Credito lancarCredito(String descricao, Double valor) throws Exception;

}

package com.mttech.lancamentos.domain;

import org.springframework.stereotype.Component;

@Component
public class LancamentoImplement implements LancamentoInterface {

    @Override 
    public Credito lancarCredito(String descricao, Double valor, Double saldoAtual) throws Exception {
        Credito credito = new Credito();
        credito.setDescricao(descricao);
        credito.setValor(valor);     
        credito.setSaldo(saldoAtual + valor);
        return credito;
    }

    @Override 
    public Debito lancarDebito(String descricao, Double valor, Double saldoAtual) throws Exception {
        Debito debito = new Debito();
        debito.setDescricao(descricao);
        debito.setValor(valor);     
        debito.setSaldo(saldoAtual - valor);
        return debito;
    }
    
}

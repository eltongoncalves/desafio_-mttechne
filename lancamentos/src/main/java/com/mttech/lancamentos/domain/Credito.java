package com.mttech.lancamentos.domain;

public class Credito extends Lancamento {

    Credito() {
        setTipo("C");
    }       

    @Override
    public void setValor(Double valor) throws Exception {
        if (valor <= 0)
            throw new IllegalArgumentException("O valor do crédito não pode ser menor ou igual a zero");
       super.setValor(valor);
    }

    protected void calcularSaldo(Double saldoAtual) {
        super.setSaldo(saldoAtual + getValor());
    }


}

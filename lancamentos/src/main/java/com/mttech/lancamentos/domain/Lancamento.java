package com.mttech.lancamentos.domain;

import java.time.Instant;

public class Lancamento {

    private String descricao;
    private String tipo;
    private Double valor;
    private Double saldo;
    private Instant dataHora;

    Lancamento() {
        setDataHora(Instant.now());
    }

    public void setDescricao(String descricao) throws Exception {
        if (descricao == "" || descricao == null)
            throw new IllegalArgumentException("A descricão é obrigatório");
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(Double valor) throws Exception {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    protected void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    

}

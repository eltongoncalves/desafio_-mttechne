package com.mttech.lancamentos.domain;

import java.time.Instant;

public class Credito {

    private String descricao;
    private Double valor;
    private Instant dataHora;


    public void setDescricao(String descricao) throws Exception {

        if (descricao == "" || descricao == null)
            throw new Exception("A descricão é obrigatório");
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setValor(Double valor) throws Exception {
        if (valor <= 0)
            throw new Exception("O valor do crédito não pode ser menor ou igual a zero");
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }


    
}

package com.mttech.lancamentos.domain;

import java.beans.JavaBean;
import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class LancamentoCreditoImplement implements LancamentoCreditoInterface {

    @Override 
    public Credito lancarCredito(String descricao, Double valor) throws Exception {

        Credito credito = new Credito();
        credito.setDescricao(descricao);
        credito.setValor(valor);

        //Adicona data hora na implementacão da interface, mas poderia ser uma nova regrade negócio mais elaborada
        credito.setDataHora(Instant.now());
        return credito;
    
    }
    
}

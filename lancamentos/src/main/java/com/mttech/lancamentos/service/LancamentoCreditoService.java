package com.mttech.lancamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mttech.lancamentos.controller.dto.CreditoDto;
import com.mttech.lancamentos.domain.Credito;
import com.mttech.lancamentos.domain.LancamentoCreditoImplement;
import com.mttech.lancamentos.repository.LancamentoCreditoRepository;
import com.mttech.lancamentos.repository.entity.CreditoEntity;

@Service
public class LancamentoCreditoService {


    @Autowired
    private  LancamentoCreditoRepository lancamentoCreditoRepository;
    
    private final LancamentoCreditoImplement lancamentoCreditoImplement;
    final ObjectMapper objectMapper = new ObjectMapper();

    LancamentoCreditoService(LancamentoCreditoImplement lancamentoCreditoImplement
    ) {
        this.lancamentoCreditoImplement = lancamentoCreditoImplement;
    }

    public CreditoDto lancarCredito(CreditoDto dto) throws Exception {

        Credito credito = lancamentoCreditoImplement.lancarCredito(dto.getDescricao(), dto.getValor());

        CreditoEntity creditoEntity = lancamentoCreditoRepository.save(CreditoEntity.builder()
                .descricao(credito.getDescricao())
                .valor(credito.getValor())
                .build());
 
        dto.setId(creditoEntity.getId());

        return dto;
    }

}

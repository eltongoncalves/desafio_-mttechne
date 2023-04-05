package com.mttech.lancamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mttech.lancamentos.controller.dto.CreditoDto;
import com.mttech.lancamentos.service.LancamentoCreditoService;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoCreditoService lancamentoCreditoService;

    @PostMapping("/credito") 
    public CreditoDto credito( @RequestBody CreditoDto dto) throws Exception{

        return lancamentoCreditoService.lancarCredito(dto);
    }
    
}

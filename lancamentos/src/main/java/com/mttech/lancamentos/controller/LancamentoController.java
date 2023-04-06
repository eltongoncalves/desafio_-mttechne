package com.mttech.lancamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mttech.lancamentos.controller.dto.LancamentoDto;
import com.mttech.lancamentos.service.LancamentoService;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping("/credito") 
    public LancamentoDto credito( @RequestBody LancamentoDto dto) throws Exception{
        return lancamentoService.lancarCredito(dto);
    }

    @PostMapping("/debito") 
    public LancamentoDto debito( @RequestBody LancamentoDto dto) throws Exception{
        return lancamentoService.lancarDebito(dto);
    }
    
}

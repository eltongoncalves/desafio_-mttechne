package com.mttech.lancamentos.controller;

import com.mttech.lancamentos.controller.dto.LancamentoDto;
import com.mttech.lancamentos.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping("/credito")
    public LancamentoDto credito(@RequestBody @Validated LancamentoDto dto) throws Exception {
        return lancamentoService.lancarCredito(dto);
    }

    @PostMapping("/debito")
    public LancamentoDto debito(@RequestBody @Validated LancamentoDto dto) throws Exception {
        return lancamentoService.lancarDebito(dto);
    }

}

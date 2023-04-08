package com.mttech.lancamentos.controller;

import com.mttech.lancamentos.controller.dto.SaldoDiarioConsolidadoDto;
import com.mttech.lancamentos.service.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorio")
public class RelatorioSaldoController {

    @Autowired
    private SaldoService saldoService;

    @GetMapping("/saldo")
    public Double saldo() throws Exception {
        return saldoService.buscarSaldoAtual();
    }

    @GetMapping("/saldo/{date}")
    public SaldoDiarioConsolidadoDto saldoDiarioConsolidado(@PathVariable String date) throws Exception {
        return saldoService.saldoDiarioConsolidado(date);
    }

}

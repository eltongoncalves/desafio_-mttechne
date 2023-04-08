package com.mttech.lancamentos.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SaldoDiarioConsolidadoDto {
    private Double saldoConsolidadoTotal;
    private Double saldoConsolidadoCredito;
    private Double saldoConsolidadoDebito;
    private List<LancamentoDto> lancamentos;
}

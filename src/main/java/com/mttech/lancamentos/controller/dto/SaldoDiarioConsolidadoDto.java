package com.mttech.lancamentos.controller.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaldoDiarioConsolidadoDto {
    private Double saldoConsolidadoTotal;
    private Double saldoConsolidadoCredito;
    private Double saldoConsolidadoDebito;
    private List<LancamentoDto> lancamentos;
}

package com.mttech.lancamentos.controller.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LancamentoDto {
    private Long id;
    private String descricao; 
    private String tipo; 
    private Double valor;
    private Double saldo;
    private Instant dataHora;
}

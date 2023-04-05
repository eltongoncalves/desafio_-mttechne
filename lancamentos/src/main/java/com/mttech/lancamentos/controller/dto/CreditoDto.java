package com.mttech.lancamentos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditoDto {
    private Long id;
    private String descricao; 
    private Double valor;
}

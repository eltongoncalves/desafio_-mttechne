package com.mttech.lancamentos.controller.mapper;

import com.mttech.lancamentos.controller.dto.LancamentoDto;
import com.mttech.lancamentos.entity.LancamentoEntity;

public class LancamentoMapper {

    public static LancamentoDto toMap(LancamentoEntity entity) {
        return LancamentoDto.builder()
                .id(entity.getId())
                .descricao(entity.getDescricao())
                .valor(entity.getValor())
                .tipo(entity.getTipo())
                .dataHora(entity.getDataHora())
                .saldo(entity.getSaldo())
                .build();
    }

}

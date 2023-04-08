package com.mttech.lancamentos.service;

import com.mttech.lancamentos.controller.dto.LancamentoDto;
import com.mttech.lancamentos.controller.mapper.LancamentoMapper;
import com.mttech.lancamentos.domain.Credito;
import com.mttech.lancamentos.domain.Debito;
import com.mttech.lancamentos.domain.LancamentoImplement;
import com.mttech.lancamentos.entity.LancamentoEntity;
import com.mttech.lancamentos.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    private final LancamentoImplement lancamentoImplement;
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private SaldoService relatorioService;

    LancamentoService(LancamentoImplement lancamentoImplement) {
        this.lancamentoImplement = lancamentoImplement;
    }

    public LancamentoDto lancarCredito(LancamentoDto dto) throws Exception {

        Credito credito = lancamentoImplement.lancarCredito(dto.getDescricao(), dto.getValor(), relatorioService.buscarSaldoAtual());

        LancamentoEntity entity = lancamentoRepository.save(
                LancamentoEntity.builder()
                        .descricao(credito.getDescricao())
                        .valor(credito.getValor())
                        .saldo(credito.getSaldo())
                        .tipo(credito.getTipo())
                        .dataHora(credito.getDataHora())
                        .build());

        relatorioService.atualizarSaldoAtual(credito.getSaldo());

        return LancamentoMapper.toMap(entity);
    }

    public LancamentoDto lancarDebito(LancamentoDto dto) throws Exception {

        Debito debito = lancamentoImplement.lancarDebito(dto.getDescricao(), dto.getValor(), relatorioService.buscarSaldoAtual());

        LancamentoEntity entity = lancamentoRepository.save(
                LancamentoEntity.builder()
                        .descricao(debito.getDescricao())
                        .valor(debito.getValor())
                        .saldo(debito.getSaldo())
                        .tipo(debito.getTipo())
                        .dataHora(debito.getDataHora())
                        .build());

        relatorioService.atualizarSaldoAtual(debito.getSaldo());

        return LancamentoMapper.toMap(entity);
    }


}

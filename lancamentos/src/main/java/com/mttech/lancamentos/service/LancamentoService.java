package com.mttech.lancamentos.service;

import java.time.Instant;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mttech.lancamentos.controller.dto.LancamentoDto;
import com.mttech.lancamentos.controller.mapper.LancamentoMapper;
import com.mttech.lancamentos.domain.Credito;
import com.mttech.lancamentos.domain.Debito;
import com.mttech.lancamentos.domain.LancamentoImplement;
import com.mttech.lancamentos.repository.LancamentoRepository;
import com.mttech.lancamentos.repository.SaldoAtualRepository;
import com.mttech.lancamentos.repository.entity.LancamentoEntity;
import com.mttech.lancamentos.repository.entity.SaldoAtualEntity;

@Service
public class LancamentoService {

    @Autowired
    private SaldoAtualRepository saldoAtualRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    private final LancamentoImplement lancamentoImplement;

    LancamentoService(LancamentoImplement lancamentoImplement) {
        this.lancamentoImplement = lancamentoImplement;
    }

    public LancamentoDto lancarCredito(LancamentoDto dto) throws Exception {

        Credito credito = lancamentoImplement.lancarCredito(dto.getDescricao(), dto.getValor(), buscarSaldoAtual());

        LancamentoEntity entity = lancamentoRepository.save(
                LancamentoEntity.builder()
                        .descricao(credito.getDescricao())
                        .valor(credito.getValor())
                        .saldo(credito.getSaldo())
                        .tipo(credito.getTipo())
                        .dataHora(credito.getDataHora())
                        .build());

        atualizarSaldoAtual(credito.getSaldo());

        return LancamentoMapper.toMap(entity);
    }

    public LancamentoDto lancarDebito(LancamentoDto dto) throws Exception {

        Debito debito = lancamentoImplement.lancarDebito(dto.getDescricao(), dto.getValor(), buscarSaldoAtual());

        LancamentoEntity entity = lancamentoRepository.save(
                LancamentoEntity.builder()
                        .descricao(debito.getDescricao())
                        .valor(debito.getValor())
                        .saldo(debito.getSaldo())
                        .tipo(debito.getTipo())
                        .dataHora(debito.getDataHora())
                        .build());

        atualizarSaldoAtual(debito.getSaldo());

        return LancamentoMapper.toMap(entity);
    }

    private Double buscarSaldoAtual() {
        Optional<SaldoAtualEntity> result = saldoAtualRepository.findById(1L);
        if (!result.isPresent())
            return inicializarSaldoAtual(0.0);
        return result.get().getSaldo();
    }

    private Double inicializarSaldoAtual(Double valorInicial) {
        saldoAtualRepository.save(
                SaldoAtualEntity.builder()
                        .saldo(valorInicial)
                        .dataUpdate(Instant.now())
                        .build());
        return valorInicial;
    }

    private void atualizarSaldoAtual(Double saldoAtual) {
        saldoAtualRepository.save(
                SaldoAtualEntity.builder()
                        .id(1L)
                        .saldo(saldoAtual)
                        .dataUpdate(Instant.now())
                        .build());
    }

}

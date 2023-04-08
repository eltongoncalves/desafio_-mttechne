package com.mttech.lancamentos.service;

import com.mttech.lancamentos.controller.dto.LancamentoDto;
import com.mttech.lancamentos.controller.dto.SaldoDiarioConsolidadoDto;
import com.mttech.lancamentos.controller.mapper.LancamentoMapper;
import com.mttech.lancamentos.domain.TipoLancamentoEnum;
import com.mttech.lancamentos.entity.LancamentoEntity;
import com.mttech.lancamentos.entity.SaldoAtualEntity;
import com.mttech.lancamentos.repository.LancamentoRepository;
import com.mttech.lancamentos.repository.SaldoAtualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaldoService {

    @Autowired
    private SaldoAtualRepository saldoAtualRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Double buscarSaldoAtual() {
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

    public void atualizarSaldoAtual(Double saldoAtual) {
        saldoAtualRepository.save(
                SaldoAtualEntity.builder()
                        .id(1L)
                        .saldo(saldoAtual)
                        .dataUpdate(Instant.now())
                        .build());
    }

    public SaldoDiarioConsolidadoDto saldoDiarioConsolidado(String date) {

        List<LancamentoEntity> lancamentos = lancamentoRepository.saldoDiarioConsolidade(date);

        Double saldoConsolidadoCredito = lancamentos.stream()
                .filter(l -> l.getTipo().contains(TipoLancamentoEnum.CREDITO.toString()))
                .mapToDouble(l -> l.getValor()).sum();

        Double saldoConsolidadoDebito = lancamentos.stream()
                .filter(l -> l.getTipo().contains(TipoLancamentoEnum.DEBITO.toString()))
                .mapToDouble(l -> l.getValor()).sum();

        List<LancamentoDto> lancamentosDto = lancamentos.stream().map(l -> LancamentoMapper.toMap(l))
                .collect(Collectors.toList());

        Double saldoConsolidadoTotal = saldoConsolidadoCredito - saldoConsolidadoDebito;

        return SaldoDiarioConsolidadoDto.builder()
                .saldoConsolidadoTotal(saldoConsolidadoTotal)
                .saldoConsolidadoCredito(saldoConsolidadoCredito)
                .saldoConsolidadoDebito(saldoConsolidadoDebito)
                .lancamentos(lancamentosDto).build();

    }

}

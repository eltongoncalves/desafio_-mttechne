package com.mttech.lancamentos.repository;

import com.mttech.lancamentos.entity.SaldoAtualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoAtualRepository extends JpaRepository<SaldoAtualEntity, Long> {
}
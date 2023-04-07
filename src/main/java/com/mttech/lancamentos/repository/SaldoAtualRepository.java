package com.mttech.lancamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mttech.lancamentos.entity.SaldoAtualEntity;

@Repository
public interface SaldoAtualRepository extends JpaRepository<SaldoAtualEntity, Long> {}
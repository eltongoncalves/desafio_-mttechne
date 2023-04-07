package com.mttech.lancamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mttech.lancamentos.repository.entity.SaldoAtualEntity;

@Repository
public interface SaldoAtualRepository extends JpaRepository<SaldoAtualEntity, Long> {
    

}
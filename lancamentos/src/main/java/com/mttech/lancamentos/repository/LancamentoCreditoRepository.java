package com.mttech.lancamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mttech.lancamentos.repository.entity.CreditoEntity;

@Repository
public interface LancamentoCreditoRepository extends JpaRepository<CreditoEntity, Long> {
    
}

 
package com.mttech.lancamentos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mttech.lancamentos.entity.LancamentoEntity;
 
@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {
    
    @Query(value = "SELECT * FROM lancamento l where CONVERT(l.data_hora, DATE) = :date ", nativeQuery = true)
    List<LancamentoEntity> saldoDiarioConsolidade(@Param("date") String date );
}

 
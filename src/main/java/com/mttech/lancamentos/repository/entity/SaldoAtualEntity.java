package com.mttech.lancamentos.repository.entity;

import java.time.Instant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SALDO_ATUAL")
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public class SaldoAtualEntity {
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)   
    private Long id;
    private Double saldo;
    private Instant dataUpdate;
}
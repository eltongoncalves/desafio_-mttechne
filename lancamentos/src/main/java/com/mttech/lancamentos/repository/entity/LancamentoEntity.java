package com.mttech.lancamentos.repository.entity;


import java.time.Instant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "LANCAMENTO")
@Builder
@Data
public class LancamentoEntity  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String descricao; 
  private String tipo; 
  private Double valor;
  private Double saldo;
  private Instant dataHora;
}

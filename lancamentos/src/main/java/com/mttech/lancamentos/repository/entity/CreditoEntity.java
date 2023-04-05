package com.mttech.lancamentos.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
public class CreditoEntity  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String descricao; 
  private Double valor;
}

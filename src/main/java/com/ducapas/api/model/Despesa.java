package com.ducapas.api.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "despesa", schema = "financeiro")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private double valor;
    private Date prazo;
    private boolean pago;
    @Column(name = "diaPagamento")
    private Date diaPagamento;
    @Column(name = "diaCriacao")
    private Date diaCriacao;
}

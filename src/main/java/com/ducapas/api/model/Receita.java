package com.ducapas.api.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "receita", schema = "financeiro")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private double valor;
    private Date prazo;
    private Date diaPagamento;
    private Date diaCriacao;
    private boolean juros;
    private boolean recebido;
}

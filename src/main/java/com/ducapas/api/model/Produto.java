package com.ducapas.api.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "produtos", schema = "producao")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int quantidadeEstoque;
    private int quantidadeEstoqueMinima;
}

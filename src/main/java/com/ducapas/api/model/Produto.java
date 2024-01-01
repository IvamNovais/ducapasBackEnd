package com.ducapas.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    private Integer id;
    String descricao;
    double preco;
    int quantidadeEstoque;
}

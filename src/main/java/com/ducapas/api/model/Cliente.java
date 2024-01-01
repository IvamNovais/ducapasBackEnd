package com.ducapas.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Integer id;
    User user;
    String nomeRasaoSocial;
    String cpfCnpj;
    Endereco endereco;
}

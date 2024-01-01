package com.ducapas.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funionario {
    private Integer id;
    String nomeRasaoSocial;
    String cpfCnpj;
    Endereco endereco;
}

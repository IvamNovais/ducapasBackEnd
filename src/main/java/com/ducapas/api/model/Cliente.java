package com.ducapas.api.model;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private UUID id;
    User user;
    String nomeRasaoSocial;
    String cpfCnpj;
    Endereco endereco;
}

package com.ducapas.api.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funionario {
    private UUID id;
    String nomeRasaoSocial;
    String cpfCnpj;
    Endereco endereco;
}

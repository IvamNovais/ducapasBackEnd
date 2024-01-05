package com.ducapas.api.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private UUID id;
    String rua;
    String numero;
    String bairo;
    String cidade;

}

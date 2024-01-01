package com.ducapas.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private Integer id;
    String rua;
    String numero;
    String bairo;
    String cidade;

}

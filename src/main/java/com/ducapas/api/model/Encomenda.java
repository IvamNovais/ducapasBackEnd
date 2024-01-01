package com.ducapas.api.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Encomenda {
    private Integer id;
    private Cliente comprador;
    private Date data;
    private List<Pedido> pedidos;
    private String status;
}

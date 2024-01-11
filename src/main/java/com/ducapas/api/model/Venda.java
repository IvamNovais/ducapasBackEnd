package com.ducapas.api.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
    private UUID id;
    private Cliente comprador;
    private Date dataVenda;
    private List<Pedido> pedidos;
    private String status;
}

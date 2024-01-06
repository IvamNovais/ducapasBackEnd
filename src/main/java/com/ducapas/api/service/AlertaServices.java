package com.ducapas.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducapas.api.model.Produto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlertaServices {
    private final ProdutoService service;
    public List<Produto> getBaixoEstoque(){
        return service.getBaixoEstoque();
    }
}

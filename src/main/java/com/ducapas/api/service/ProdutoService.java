package com.ducapas.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ducapas.api.model.Produto;
import com.ducapas.api.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Produto obterProdutoPorIdOrElse(UUID id) {
        return produtoRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"produto nao encontado"));
    }

    public List<Produto> obterTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto updateProduto(Produto produto) {
        obterProdutoPorIdOrElse(produto.getId());
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Produto produto) {
        obterProdutoPorIdOrElse(produto.getId());
        produtoRepository.delete(produto);
    }
    List<Produto> getBaixoEstoque(){
        return produtoRepository.getBaixoEstoque();
    }
}

package com.ducapas.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ducapas.api.model.Produto;
import com.ducapas.api.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;



    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvarProduto(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable UUID id) {
        Produto produto = produtoService.obterProdutoPorIdOrElse(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodosProdutos() {
        List<Produto> produtos = produtoService.obterTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable UUID id, @RequestBody Produto produto) {
        produto.setId(id);
        Produto produtoAtualizado = produtoService.updateProduto(produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id) {
        Produto produto = produtoService.obterProdutoPorIdOrElse(id);
        produtoService.deleteProduto(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


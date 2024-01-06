package com.ducapas.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ducapas.api.model.Receita;
import com.ducapas.api.service.ReceitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;



    @PostMapping
    public ResponseEntity<Receita> salvarReceita(@RequestBody Receita receita) {
        Receita receitaSalvo = receitaService.salvarReceita(receita);
        return new ResponseEntity<>(receitaSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> obterReceitaPorId(@PathVariable UUID id) {
        Receita receita = receitaService.obterReceitaPorIdOrElse(id);
        return new ResponseEntity<>(receita, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Receita>> obterTodosReceitas() {
        List<Receita> receitas = receitaService.obterTodosReceitas();
        return new ResponseEntity<>(receitas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizarReceita(@PathVariable UUID id, @RequestBody Receita receita) {
        receita.setId(id);
        Receita receitaAtualizado = receitaService.updateReceita(receita);
        return new ResponseEntity<>(receitaAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReceita(@PathVariable UUID id) {
        Receita receita = receitaService.obterReceitaPorIdOrElse(id);
        receitaService.deleteReceita(receita);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


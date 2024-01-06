package com.ducapas.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ducapas.api.model.Despesa;
import com.ducapas.api.service.DespesaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/despesas")
@RequiredArgsConstructor
public class DespesaController {

    private final DespesaService despesaService;



    @PostMapping
    public ResponseEntity<Despesa> salvarDespesa(@RequestBody Despesa despesa) {
        Despesa despesaSalvo = despesaService.salvarDespesa(despesa);
        return new ResponseEntity<>(despesaSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> obterDespesaPorId(@PathVariable UUID id) {
        Despesa despesa = despesaService.obterDespesaPorIdOrElse(id);
        return new ResponseEntity<>(despesa, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> obterTodosDespesas() {
        List<Despesa> despesas = despesaService.obterTodosDespesas();
        return new ResponseEntity<>(despesas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> atualizarDespesa(@PathVariable UUID id, @RequestBody Despesa despesa) {
        despesa.setId(id);
        Despesa despesaAtualizado = despesaService.updateDespesa(despesa);
        return new ResponseEntity<>(despesaAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDespesa(@PathVariable UUID id) {
        Despesa despesa = despesaService.obterDespesaPorIdOrElse(id);
        despesaService.deleteDespesa(despesa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


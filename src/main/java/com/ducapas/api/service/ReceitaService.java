package com.ducapas.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ducapas.api.model.Receita;
import com.ducapas.api.repository.ReceitaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceitaService {
    private final ReceitaRepository repository;

    public Receita salvarReceita(Receita receita) {
        receita.setId(null);
        return repository.save(receita);
    }

    public Receita obterReceitaPorIdOrElse(UUID id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"receita nao encontada"));
    }

    public List<Receita> obterTodosReceitas() {
        return repository.findAll();
    }

    public Receita updateReceita(Receita receita) {
        obterReceitaPorIdOrElse(receita.getId());
        return repository.save(receita);
    }

    public void deleteReceita(Receita receita) {
        obterReceitaPorIdOrElse(receita.getId());
        repository.delete(receita);
    }
}

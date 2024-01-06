package com.ducapas.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ducapas.api.model.Despesa;
import com.ducapas.api.repository.DespesaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DespesaService {
    private final DespesaRepository repository;

    public Despesa salvarDespesa(Despesa despesa) {
        despesa.setId(null);
        return repository.save(despesa);
    }

    public Despesa obterDespesaPorIdOrElse(UUID id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"despesa nao encontada"));
    }

    public List<Despesa> obterTodosDespesas() {
        return repository.findAll();
    }

    public Despesa updateDespesa(Despesa despesa) {
        obterDespesaPorIdOrElse(despesa.getId());
        return repository.save(despesa);
    }

    public void deleteDespesa(Despesa despesa) {
        obterDespesaPorIdOrElse(despesa.getId());
        repository.delete(despesa);
    }
}

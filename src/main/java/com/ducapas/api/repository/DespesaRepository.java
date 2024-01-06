package com.ducapas.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducapas.api.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, UUID>{
    
}

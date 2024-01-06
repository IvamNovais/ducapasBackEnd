package com.ducapas.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducapas.api.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, UUID>{
    
}

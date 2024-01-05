package com.ducapas.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducapas.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
    
}

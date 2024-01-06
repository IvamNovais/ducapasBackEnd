package com.ducapas.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ducapas.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID>{
    @Query(value = "select * from producao.produtos p where p.quantidade_estoque <= p.quantidade_estoque_minima ", nativeQuery = true)
    List<Produto> getBaixoEstoque();
}

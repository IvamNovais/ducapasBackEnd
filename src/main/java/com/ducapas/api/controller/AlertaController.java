package com.ducapas.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducapas.api.model.Produto;
import com.ducapas.api.service.AlertaServices;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/alertas")
public class AlertaController {
    private final AlertaServices services;
    @GetMapping()
    public ResponseEntity<java.util.List<Produto>> getAlertas() {
        return new ResponseEntity<>(services.getBaixoEstoque(), HttpStatus.OK);
    }
}

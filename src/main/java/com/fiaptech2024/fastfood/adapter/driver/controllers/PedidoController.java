package com.fiaptech2024.fastfood.adapter.driver.controllers;

import com.fiaptech2024.fastfood.core.applications.ports.PedidoServicePort;
import com.fiaptech2024.fastfood.core.domain.Cliente;
import com.fiaptech2024.fastfood.core.services.dtos.PedidoServiceDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("pedido")
@AllArgsConstructor
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    @PostMapping
    public ResponseEntity create(@RequestBody PedidoServiceDto pedidoServiceDto) {
        UUID id = this.pedidoServicePort.save(pedidoServiceDto);
        Cliente cliente = new Cliente();
        var pedidoResponse = this.pedidoServicePort.save(pedidoServiceDto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

}
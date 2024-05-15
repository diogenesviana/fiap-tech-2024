package com.fiaptech2024.fastfood.adapter.driver.controllers;

import com.fiaptech2024.fastfood.core.domain.Cliente;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteServicePort;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteServicePort clienteServicePort;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable("id") UUID id) {
        var clienteResponse = clienteServicePort.getClienteById(id);
        return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Cliente> searchCliente(@RequestParam("cpf") String cpf) {
        var clienteResponse = clienteServicePort.getClienteByCpf(cpf);
        return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        var clienteResponse = clienteServicePort.saveCliente(cliente);
        return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);
    }

}
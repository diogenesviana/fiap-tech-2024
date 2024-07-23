package com.fiaptech2024.fastfood.adapter.driver.controllers.cliente;

import com.fiaptech2024.fastfood.adapter.driver.controllers.cliente.requests.ClienteCreateRequest;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable("id") UUID id) {
        com.fiaptech2024.fastfood.adapters.controllers.ClienteController clienteController = new com.fiaptech2024.fastfood.adapters.controllers.ClienteController(this.clienteRepositoryInterface);
        return new ResponseEntity<>(clienteController.get(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchCliente(@RequestParam("cpf") String cpf) {
        com.fiaptech2024.fastfood.adapters.controllers.ClienteController clienteController = new com.fiaptech2024.fastfood.adapters.controllers.ClienteController(this.clienteRepositoryInterface);
        return new ResponseEntity<>(clienteController.getByCpf(cpf), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ClienteCreateRequest request) {
        com.fiaptech2024.fastfood.adapters.controllers.ClienteController clienteController = new com.fiaptech2024.fastfood.adapters.controllers.ClienteController(this.clienteRepositoryInterface);
        return new ResponseEntity<>(clienteController.salvar(request.nome(), request.cpf(), request.email()), HttpStatus.OK);
    }

}
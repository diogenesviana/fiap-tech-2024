package com.fiaptech2024.fastfood.application.controllers.cliente.create;

import com.fiaptech2024.fastfood.adapters.controllers.ClienteController;
import com.fiaptech2024.fastfood.application.controllers.cliente.create.requests.ClienteCreateRequest;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class CreateClienteController {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    @PostMapping
    @Operation(tags = "Clientes")
    public ResponseEntity<Object> create(@RequestBody ClienteCreateRequest request) {
        ClienteController clienteController = new ClienteController(this.clienteRepositoryInterface);
        return new ResponseEntity<>(clienteController.salvar(request.nome(), request.cpf(), request.email()), HttpStatus.OK);
    }

}

package com.fiaptech2024.fastfood.adapter.controllers;

import com.fiaptech2024.fastfood.domain.Cliente;
import com.fiaptech2024.fastfood.domain.ports.ClienteServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteServicePort clienteServicePort;

    @PostMapping
    private Cliente create(@RequestBody Cliente cliente){
        return clienteServicePort.saveCliente(cliente);
    }

}
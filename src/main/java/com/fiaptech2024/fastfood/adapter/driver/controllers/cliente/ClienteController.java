package com.fiaptech2024.fastfood.adapter.driver.controllers.cliente;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente.GetCliente;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente.GetClienteInput;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente.GetClienteOutput;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetClienteByCpf.GetClienteByCpf;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetClienteByCpf.GetClienteByCpfInput;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetClienteByCpf.GetClienteByCpfOutput;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.SalvarCliente.SalvarCliente;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.SalvarCliente.SalvarClienteInput;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.SalvarCliente.SalvarClienteOutput;
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
    public ResponseEntity<GetClienteOutput> get(@PathVariable("id") UUID id) {
        GetCliente getCliente = new GetCliente(this.clienteRepositoryInterface);
        GetClienteOutput output = getCliente.execute(new GetClienteInput(id));
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<GetClienteByCpfOutput> searchCliente(@RequestParam("cpf") String cpf) {
        GetClienteByCpf getClienteByCpf = new GetClienteByCpf(this.clienteRepositoryInterface);
        GetClienteByCpfOutput output = getClienteByCpf.execute(new GetClienteByCpfInput(cpf));
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SalvarClienteOutput> create(@RequestBody SalvarClienteInput input) {
        SalvarCliente salvarCliente = new SalvarCliente(this.clienteRepositoryInterface);
        SalvarClienteOutput output = salvarCliente.execute(input);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

}
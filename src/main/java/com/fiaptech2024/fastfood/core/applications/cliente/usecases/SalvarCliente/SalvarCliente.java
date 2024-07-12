package com.fiaptech2024.fastfood.core.applications.cliente.usecases.SalvarCliente;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

import java.time.Instant;
import java.util.UUID;

public class SalvarCliente {

    private final ClienteRepositoryInterface clienteRepository;

    public SalvarCliente(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public SalvarClienteOutput execute(SalvarClienteInput input) {
        Cliente cliente = new Cliente(UUID.randomUUID(), input.nome(), input.cpf(), input.email(), Instant.now());
        cliente = this.clienteRepository.saveCliente(cliente);
        return new SalvarClienteOutput(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getDataCriacao()
        );
    }

}

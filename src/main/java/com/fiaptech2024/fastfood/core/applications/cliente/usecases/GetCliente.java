package com.fiaptech2024.fastfood.core.applications.cliente.usecases;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

import java.util.UUID;

public class GetCliente {

    private final ClienteRepositoryInterface clienteRepository;

    public GetCliente(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente execute(UUID id) {
        Cliente cliente = this.clienteRepository.getClienteById(id);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        return cliente;
    }

}

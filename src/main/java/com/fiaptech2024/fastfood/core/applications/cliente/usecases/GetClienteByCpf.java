package com.fiaptech2024.fastfood.core.applications.cliente.usecases;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

public class GetClienteByCpf {

    private final ClienteRepositoryInterface clienteRepository;

    public GetClienteByCpf(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente execute(String cpf) {
        Cliente cliente = this.clienteRepository.getClienteByCpf(cpf);
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        return cliente;
    }

}

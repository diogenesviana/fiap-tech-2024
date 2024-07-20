package com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

public class GetCliente {

    private final ClienteRepositoryInterface clienteRepository;

    public GetCliente(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public GetClienteOutput execute(GetClienteInput input) {
        Cliente cliente = this.clienteRepository.getClienteById(input.id());
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        return new GetClienteOutput(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getDataCriacao()
        );
    }

}

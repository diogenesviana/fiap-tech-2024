package com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetClienteByCpf;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

public class GetClienteByCpf {

    private final ClienteRepositoryInterface clienteRepository;

    public GetClienteByCpf(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public GetClienteByCpfOutput execute(GetClienteByCpfInput input) {
        Cliente cliente = this.clienteRepository.getClienteByCpf(input.cpf());
        if (cliente == null) {
            throw new EntityNotFoundException("Cliente não encontrado");
        }
        return new GetClienteByCpfOutput(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getDataCriacao()
        );
    }

}

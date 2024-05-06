package com.fiaptech2024.fastfood.domain.services;

import com.fiaptech2024.fastfood.domain.Cliente;
import com.fiaptech2024.fastfood.domain.ports.ClienteServicePort;
import com.fiaptech2024.fastfood.domain.ports.ClienteRepositoryPort;

public class ClienteService implements ClienteServicePort {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteService(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepositoryPort.saveCliente(cliente);
    }

}
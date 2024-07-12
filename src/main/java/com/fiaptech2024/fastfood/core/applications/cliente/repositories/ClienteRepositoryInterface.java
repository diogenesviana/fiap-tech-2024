package com.fiaptech2024.fastfood.core.applications.cliente.repositories;

import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

import java.util.UUID;

public interface ClienteRepositoryInterface {

    Cliente getClienteById(UUID id);

    Cliente getClienteByCpf(String cpf);

    Cliente saveCliente(Cliente cliente);

}

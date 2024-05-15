package com.fiaptech2024.fastfood.core.applications.ports;

import java.util.UUID;

import com.fiaptech2024.fastfood.core.domain.Cliente;

public interface ClienteRepositoryPort {

    Cliente saveCliente(Cliente cliente);

    Boolean existsClienteByCpf(String cpf);

    Cliente getClienteByCpf(String cpf);

    Cliente getClienteById(UUID id);


}
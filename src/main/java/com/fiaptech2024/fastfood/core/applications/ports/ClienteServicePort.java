package com.fiaptech2024.fastfood.core.applications.ports;

import java.util.UUID;

import com.fiaptech2024.fastfood.core.domain.Cliente;

public interface ClienteServicePort {

    Cliente saveCliente(Cliente cliente);

    Cliente getClienteById(UUID id);

    Cliente getClienteByCpf(String cpf);

}
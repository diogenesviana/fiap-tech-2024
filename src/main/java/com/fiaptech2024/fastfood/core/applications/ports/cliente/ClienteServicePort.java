package com.fiaptech2024.fastfood.core.applications.ports.cliente;

import java.util.UUID;

import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;
import com.fiaptech2024.fastfood.core.services.cliente.dtos.ClienteServiceSaveClienteDto;

public interface ClienteServicePort {

    Cliente saveCliente(ClienteServiceSaveClienteDto clienteDto);

    Cliente getClienteById(UUID id);

    Cliente getClienteByCpf(String cpf);

}
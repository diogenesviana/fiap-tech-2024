package com.fiaptech2024.fastfood.domain.ports;

import com.fiaptech2024.fastfood.domain.Cliente;

public interface ClienteRepositoryPort {

    Cliente saveCliente(Cliente cliente);

}
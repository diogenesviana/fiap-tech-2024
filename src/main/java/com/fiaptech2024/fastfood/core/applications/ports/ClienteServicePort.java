package com.fiaptech2024.fastfood.core.applications.ports;

import com.fiaptech2024.fastfood.core.domain.Cliente;

public interface ClienteServicePort {

    Cliente saveCliente(Cliente cliente);

}
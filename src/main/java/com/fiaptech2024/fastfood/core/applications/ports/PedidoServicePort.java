package com.fiaptech2024.fastfood.core.applications.ports;

import com.fiaptech2024.fastfood.core.services.dtos.PedidoServiceDto;

import java.util.UUID;

public interface PedidoServicePort {

    public UUID save(PedidoServiceDto pedidoServiceDto);

}
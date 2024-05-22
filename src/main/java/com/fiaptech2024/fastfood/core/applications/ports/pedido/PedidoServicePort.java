package com.fiaptech2024.fastfood.core.applications.ports.pedido;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceDto;

import java.util.List;
import java.util.UUID;

public interface PedidoServicePort {

    public UUID criarPedido(PedidoServiceDto pedidoServiceDto);

    public List<PedidoDTO> listar(PedidoStatus pedidoStatus);
}
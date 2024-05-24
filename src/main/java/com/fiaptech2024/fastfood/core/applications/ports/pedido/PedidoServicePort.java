package com.fiaptech2024.fastfood.core.applications.ports.pedido;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceCriarPedidoDto;

import java.util.List;
import java.util.UUID;

public interface PedidoServicePort {

    public UUID criarPedido(PedidoServiceCriarPedidoDto pedidoServiceCriarPedidoDto);

    public List<PedidoDTO> listar(PedidoStatus pedidoStatus);
}
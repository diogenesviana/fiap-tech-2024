package com.fiaptech2024.fastfood.core.applications.ports.pedido;

import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;

import java.util.List;

public interface PedidoRepositoryPort {

    public Pedido criarPedido(Pedido pedido);

    public List<PedidoDTO> listar(PedidoStatus pedidoStatus);
}
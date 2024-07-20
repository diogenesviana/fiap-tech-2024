package com.fiaptech2024.fastfood.core.applications.pedido.repositories;

import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;

import java.util.List;
import java.util.UUID;

public interface PedidoRepositoryInterace {

    public Pedido criarPedido(Pedido pedido);

//    public List<PedidoDTO> listar(PedidoStatus pedidoStatus);

//    public Pedido getById(UUID id);

}

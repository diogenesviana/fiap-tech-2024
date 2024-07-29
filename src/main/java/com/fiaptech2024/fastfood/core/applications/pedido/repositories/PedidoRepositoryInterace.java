package com.fiaptech2024.fastfood.core.applications.pedido.repositories;

import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPedido;

import java.util.List;
import java.util.UUID;

public interface PedidoRepositoryInterace {

    public Pedido criarPedido(Pedido pedido);

    public List<Pedido> listarPorStatus(StatusPedido statusPedido);

    public List<Pedido> listar();

    public Pedido getById(UUID id);

    public Pedido atualizarStatus(Pedido pedido);

}

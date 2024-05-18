package com.fiaptech2024.fastfood.core.applications.ports.pedido;

import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;

public interface PedidoRepositoryPort {

    public Pedido criarPedido(Pedido pedido);

}
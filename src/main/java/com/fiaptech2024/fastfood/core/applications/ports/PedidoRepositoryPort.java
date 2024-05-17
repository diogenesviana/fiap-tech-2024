package com.fiaptech2024.fastfood.core.applications.ports;

import com.fiaptech2024.fastfood.core.domain.Pedido;

public interface PedidoRepositoryPort {

    public Pedido save(Pedido pedido);

}
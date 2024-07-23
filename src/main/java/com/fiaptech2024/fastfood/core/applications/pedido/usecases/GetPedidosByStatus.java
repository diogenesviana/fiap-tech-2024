package com.fiaptech2024.fastfood.core.applications.pedido.usecases;

import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;

import java.util.List;

public class GetPedidosByStatus {

    private final PedidoRepositoryInterace pedidoRepository;

    public GetPedidosByStatus(PedidoRepositoryInterace pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> execute(PedidoStatus pedidoStatus) {
        return this.pedidoRepository.listarPorStatus(pedidoStatus);
    }

}

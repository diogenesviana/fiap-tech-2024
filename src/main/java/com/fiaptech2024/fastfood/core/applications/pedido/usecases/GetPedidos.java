package com.fiaptech2024.fastfood.core.applications.pedido.usecases;

import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;

import java.util.List;

public class GetPedidos {

    private final PedidoRepositoryInterace pedidoRepository;

    public GetPedidos(PedidoRepositoryInterace pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> execute() {
        return this.pedidoRepository.listar();
    }

}

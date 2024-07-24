package com.fiaptech2024.fastfood.core.applications.pedido.usecases;

import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;

import java.util.UUID;

public class AtualizarStatusPedido {

    private final PedidoRepositoryInterace pedidoRepository;

    public AtualizarStatusPedido(PedidoRepositoryInterace pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void execute(UUID id, PedidoStatus pedidoStatus) {
        Pedido pedido = this.pedidoRepository.getById(id);
        if (pedido == null) {
            throw new EntityNotFoundException("Pedido não encontrado");
        }
        pedido.setStatus(pedidoStatus);
        this.pedidoRepository.atualizarStatus(pedido);
    }

}

package com.fiaptech2024.fastfood.core.applications.pedido.usecases;

import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.util.UUID;

public class AtualizarStatusPagamento {

    private final PedidoRepositoryInterace pedidoRepository;

    public AtualizarStatusPagamento(PedidoRepositoryInterace pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido execute(UUID id, StatusPagamento statusPagamento) {
        Pedido pedido = this.pedidoRepository.getById(id);
        if (pedido == null) {
            throw new EntityNotFoundException("Pedido não encontrado");
        }
        pedido.setStatusPagamento(statusPagamento);
        return this.pedidoRepository.atualizarStatus(pedido);
    }

}

package com.fiaptech2024.fastfood.core.services.pagamento;

import com.fiaptech2024.fastfood.core.applications.ports.pagamento.PagamentoServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;
import com.fiaptech2024.fastfood.core.services.exception.EntityNotFoundException;

import java.util.UUID;

public class PagamentoService implements PagamentoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PagamentoService(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public void solicitarPagamento(UUID id) {
        Pedido pedido = this.pedidoRepositoryPort.getById(id);
        if (pedido == null) {
            throw new EntityNotFoundException("Pedido não encontrado");
        }
        pedido.setStatus(PedidoStatus.FINALIZADO);
        pedido.setStatusPagamento(StatusPagamento.PAGO);
        this.pedidoRepositoryPort.realizarPagamento(pedido);
    }

}

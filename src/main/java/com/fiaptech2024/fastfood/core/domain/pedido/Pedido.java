package com.fiaptech2024.fastfood.core.domain.pedido;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private UUID id;

    private UUID clienteId;

    private PedidoStatus status;

    private StatusPagamento statusPagamento;

    private List<PedidoItem> items;

    public Pedido(UUID id, UUID clienteId, PedidoStatus status, StatusPagamento statusPagamento) {
        this.id = id;
        this.clienteId = clienteId;
        this.status = status;
        this.statusPagamento = statusPagamento;
        this.items = new ArrayList<>();
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getClienteId() {
        return this.clienteId;
    }

    public PedidoStatus getStatus() {
        return this.status;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public List<PedidoItem> getItems() {
        return this.items;
    }

    public void addItem(PedidoItem pedidoItem) {
        this.items.add(pedidoItem);
    }

    public BigDecimal getValor() {
        BigDecimal valor = BigDecimal.valueOf(0);
        for (PedidoItem pedidoItem : this.items) {
            valor = valor.add(pedidoItem.getValorItem());
        }
        return valor;
    }

    public void setStatus(PedidoStatus status) {
        this.status=status;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}

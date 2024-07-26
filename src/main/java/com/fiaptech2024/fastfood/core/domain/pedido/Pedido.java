package com.fiaptech2024.fastfood.core.domain.pedido;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private UUID id;
    private UUID clienteId;
    private StatusPedido statusPedido;
    private StatusPagamento statusPagamento;
    private Instant dataCriacao;
    private List<PedidoItem> items;

    public Pedido(UUID id, UUID clienteId, StatusPedido statusPedido, StatusPagamento statusPagamento, Instant dataCriacao) {
        this.id = id;
        this.clienteId = clienteId;
        this.statusPedido = statusPedido;
        this.statusPagamento = statusPagamento;
        this.dataCriacao = dataCriacao;
        this.items = new ArrayList<>();
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getClienteId() {
        return this.clienteId;
    }

    public StatusPedido getStatusPedido() {
        return this.statusPedido;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
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

    public void setStatus(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public boolean isPago() {
        return this.statusPagamento == StatusPagamento.PAGO;
    }

}

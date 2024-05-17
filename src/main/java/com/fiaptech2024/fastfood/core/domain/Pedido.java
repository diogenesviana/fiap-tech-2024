package com.fiaptech2024.fastfood.core.domain;

import com.fiaptech2024.fastfood.core.domain.enums.PedidoStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private UUID id;

    private UUID clienteId;

    private PedidoStatus status;

    private List<PedidoItem> items;

    public Pedido(UUID id, UUID clienteId, PedidoStatus status) {
        this.id = id;
        this.clienteId = clienteId;
        this.status = status;
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

    public List<PedidoItem> getItems() {
        return this.items;
    }

    public void addItem(PedidoItem pedidoItem) {
        this.items.add(pedidoItem);
    }

    public BigDecimal getValor() {
        BigDecimal valor = BigDecimal.valueOf(0);
        for (PedidoItem pedidoItem : this.items) {
            valor.add(pedidoItem.getValorItem());
        }
        return valor;
    }
}

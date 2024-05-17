package com.fiaptech2024.fastfood.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class PedidoItem {

    private UUID id;

    private UUID itemId;

    private BigDecimal valor;

    private int quantidade;

    public PedidoItem(UUID id, UUID itemId, BigDecimal valor, int quantidade) {
        this.id = id;
        this.itemId = itemId;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getItemId() {
        return this.itemId;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public BigDecimal getValorItem() {
        return this.valor.multiply(BigDecimal.valueOf(this.quantidade));
    }
}

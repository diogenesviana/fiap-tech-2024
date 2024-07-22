package com.fiaptech2024.fastfood.core.applications.pedido.usecases.getpedidos;

import java.math.BigDecimal;
import java.util.UUID;

public record GetPedidosItemOutput(UUID itemId, String produtoNome, int quantidade, BigDecimal valor) {
}

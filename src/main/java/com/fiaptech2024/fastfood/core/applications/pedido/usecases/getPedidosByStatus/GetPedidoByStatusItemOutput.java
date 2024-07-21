package com.fiaptech2024.fastfood.core.applications.pedido.usecases.getPedidosByStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record GetPedidoByStatusItemOutput(UUID itemId, String produtoNome, int quantidade, BigDecimal valor) {
}

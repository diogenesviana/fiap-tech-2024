package com.fiaptech2024.fastfood.core.applications.pedido.usecases.getPedidosByStatus;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record GetPedidoByStatusOutput(UUID id, UUID clienteId, String clienteNome, PedidoStatus pedidoStatus, StatusPagamento statusPagamento, BigDecimal valor, Instant dataCriacao, List<GetPedidoByStatusItemOutput> itens) {
}

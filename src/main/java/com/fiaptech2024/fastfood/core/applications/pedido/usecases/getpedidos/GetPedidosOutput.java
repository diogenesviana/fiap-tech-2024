package com.fiaptech2024.fastfood.core.applications.pedido.usecases.getpedidos;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record GetPedidosOutput(UUID id, UUID clienteId, String clienteNome, PedidoStatus pedidoStatus, StatusPagamento statusPagamento, BigDecimal valor, Instant dataCriacao, List<GetPedidosItemOutput> itens) {
}

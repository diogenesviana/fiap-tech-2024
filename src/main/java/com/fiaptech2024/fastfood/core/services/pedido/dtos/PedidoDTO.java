package com.fiaptech2024.fastfood.core.services.pedido.dtos;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record PedidoDTO(UUID id ,BigDecimal preco, PedidoStatus pedidoStatus, StatusPagamento statusPagamento, String cliente, List<PedidoItemDTO> items, Instant dataCriacao){
}

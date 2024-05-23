package com.fiaptech2024.fastfood.core.services.pedido.dtos;

import java.util.List;
import java.util.UUID;

public record PedidoServiceCriarPedidoDto(UUID cliente_id, List<PedidoServiceCriarPedidoItemDto> itens) {
}

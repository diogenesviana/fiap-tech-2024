package com.fiaptech2024.fastfood.core.services.pedido.dtos;

import java.util.List;
import java.util.UUID;

public record PedidoServiceDto(UUID cliente_id, List<PedidoServiceItemDto> itens) {
}

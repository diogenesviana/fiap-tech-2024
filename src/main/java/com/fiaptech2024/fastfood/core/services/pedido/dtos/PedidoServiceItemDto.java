package com.fiaptech2024.fastfood.core.services.pedido.dtos;

import java.util.UUID;

public record PedidoServiceItemDto(UUID item_id, int quantidade) {
}

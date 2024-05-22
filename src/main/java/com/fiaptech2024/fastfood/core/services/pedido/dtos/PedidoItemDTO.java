package com.fiaptech2024.fastfood.core.services.pedido.dtos;

import java.util.UUID;

public record PedidoItemDTO(UUID itemId, int quantidade, String produto){
}

package com.fiaptech2024.fastfood.core.applications.pedido.usecases;

import java.util.UUID;

public record CriarPedidoItemInput(UUID item_id, int quantidade) {
}

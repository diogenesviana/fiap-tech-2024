package com.fiaptech2024.fastfood.adapter.driver.controllers.pedido.requests;

import java.util.UUID;

public record PedidoCreateItemRequest(UUID item_id, int quantidade) {

}

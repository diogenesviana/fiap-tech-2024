package com.fiaptech2024.fastfood.adapter.driver.controllers.pedido.requests;

import java.util.List;
import java.util.UUID;

public record PedidoCreateRequest(UUID cliente_id, List<ItemPedido> itens) {

    public static record ItemPedido(UUID item_id, int quantidade) {
    }

}

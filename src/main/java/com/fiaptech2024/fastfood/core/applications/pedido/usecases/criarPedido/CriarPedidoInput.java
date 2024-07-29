package com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido;

import java.util.List;
import java.util.UUID;

public record CriarPedidoInput(UUID cliente_id, List<CriarPedidoItemInput> items) {
}

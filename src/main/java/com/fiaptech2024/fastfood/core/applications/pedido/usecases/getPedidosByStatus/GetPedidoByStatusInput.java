package com.fiaptech2024.fastfood.core.applications.pedido.usecases.getPedidosByStatus;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;

public record GetPedidoByStatusInput(PedidoStatus pedidoStatus) {
}

package com.fiaptech2024.fastfood.adapter.driver.controllers.pedido.requests;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;

public record AtualizarStatusRequest(PedidoStatus pedidoStatus) {
}

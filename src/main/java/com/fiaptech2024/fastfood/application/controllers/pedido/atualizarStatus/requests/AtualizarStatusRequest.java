package com.fiaptech2024.fastfood.application.controllers.pedido.atualizarStatus.requests;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;

public record AtualizarStatusRequest(PedidoStatus pedidoStatus) {
}

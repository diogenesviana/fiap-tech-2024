package com.fiaptech2024.fastfood.application.controllers.pedido.atualizarStatus.requests;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.util.UUID;

public record AtualizarStatusPagamentoRequest(UUID id, StatusPagamento statusPagamento) {
}

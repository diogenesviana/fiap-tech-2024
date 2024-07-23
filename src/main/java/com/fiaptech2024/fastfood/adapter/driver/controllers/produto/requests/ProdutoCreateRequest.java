package com.fiaptech2024.fastfood.adapter.driver.controllers.produto.requests;

import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.math.BigDecimal;

public record ProdutoCreateRequest(String nome, BigDecimal preco, TipoProduto tipoProduto) {
}

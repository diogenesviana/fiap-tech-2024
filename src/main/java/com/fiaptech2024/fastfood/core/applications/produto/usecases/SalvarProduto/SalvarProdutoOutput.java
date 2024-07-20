package com.fiaptech2024.fastfood.core.applications.produto.usecases.SalvarProduto;

import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.math.BigDecimal;
import java.util.UUID;

public record SalvarProdutoOutput(UUID id, String nome, BigDecimal preco, TipoProduto tipoProduto)  {
}

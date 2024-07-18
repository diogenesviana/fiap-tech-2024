package com.fiaptech2024.fastfood.core.applications.produto.usecases.atualizarProduto;

import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.math.BigDecimal;
import java.util.UUID;

public record AtualizarProdutoInput(String nome, BigDecimal preco, TipoProduto tipoProduto){
}

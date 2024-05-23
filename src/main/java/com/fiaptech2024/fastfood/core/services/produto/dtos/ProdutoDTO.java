package com.fiaptech2024.fastfood.core.services.produto.dtos;

import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import com.fiaptech2024.fastfood.core.services.exception.RegraDeNegocioException;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoDTO(UUID id, String nome, BigDecimal preco, TipoProduto tipoProduto) {
}

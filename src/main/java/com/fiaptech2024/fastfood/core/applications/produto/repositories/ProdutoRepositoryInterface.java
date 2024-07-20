package com.fiaptech2024.fastfood.core.applications.produto.repositories;

import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryInterface {

    Produto saveProduto(Produto produto);

    List<Produto> getProdutoByTipoProduto(TipoProduto tipoProduto);

    void deleteProdutoById(UUID id);

    void update(UUID id, String nome, BigDecimal preco, TipoProduto tipoProduto);

    Produto getById(UUID id);
}

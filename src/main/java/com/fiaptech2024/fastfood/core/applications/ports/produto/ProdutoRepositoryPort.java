package com.fiaptech2024.fastfood.core.applications.ports.produto;

import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryPort {

    Produto save(Produto produto);

    List<Produto> findByTipoProduto(TipoProduto tipoProduto);

    Produto findByProduto(String produto);

    Produto getById(UUID id);
}

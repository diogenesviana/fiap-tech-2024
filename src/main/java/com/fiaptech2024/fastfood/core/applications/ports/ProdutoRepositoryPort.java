package com.fiaptech2024.fastfood.core.applications.ports;

import com.fiaptech2024.fastfood.core.domain.Produto;
import com.fiaptech2024.fastfood.core.domain.TipoProduto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryPort {

    Produto save(Produto produto);

    List<Produto> findByTipoProduto(TipoProduto tipoProduto);

    Produto findByProduto(String produto);
}

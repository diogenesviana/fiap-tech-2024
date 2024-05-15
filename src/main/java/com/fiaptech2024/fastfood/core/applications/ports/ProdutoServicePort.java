package com.fiaptech2024.fastfood.core.applications.ports;

import com.fiaptech2024.fastfood.core.domain.Produto;
import com.fiaptech2024.fastfood.core.domain.TipoProduto;

import java.util.List;

public interface ProdutoServicePort {

    Produto save(Produto produto);

    List<Produto> findByTipoProduto(TipoProduto tipoProduto);

    Produto findByProduto(String produto);
}

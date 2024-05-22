package com.fiaptech2024.fastfood.core.applications.ports.produto;

import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.util.List;
import java.util.UUID;

public interface ProdutoServicePort {

    Produto save(Produto produto);

    List<Produto> findByTipoProduto(TipoProduto tipoProduto);

    void deleteById(UUID id);
}

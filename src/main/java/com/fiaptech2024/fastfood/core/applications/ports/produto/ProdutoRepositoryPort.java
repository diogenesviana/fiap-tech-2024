package com.fiaptech2024.fastfood.core.applications.ports.produto;

import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import com.fiaptech2024.fastfood.core.services.produto.dtos.ProdutoDTO;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryPort {

    Produto save(ProdutoDTO produtoDTO);

    List<Produto> findByTipoProduto(TipoProduto tipoProduto);

    Produto findByProduto(String produto);

    Produto getById(UUID id);

    void deleteById(UUID id);

    List<Produto> findProdutosByItemsProdutos(UUID id);

    void update(UUID id, ProdutoDTO produtoDTO);
}

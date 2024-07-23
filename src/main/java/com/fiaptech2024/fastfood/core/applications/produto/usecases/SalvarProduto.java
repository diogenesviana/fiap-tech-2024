package com.fiaptech2024.fastfood.core.applications.produto.usecases;

import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.math.BigDecimal;
import java.util.UUID;

public class SalvarProduto {

    private final ProdutoRepositoryInterface produtoRepository;

    public SalvarProduto(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto execute(String nome, BigDecimal preco, TipoProduto tipoProduto) {
        Produto produto = new Produto(UUID.randomUUID(), nome, preco, tipoProduto);
        return this.produtoRepository.saveProduto(produto);
    }
}

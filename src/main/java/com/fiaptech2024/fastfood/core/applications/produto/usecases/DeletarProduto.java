package com.fiaptech2024.fastfood.core.applications.produto.usecases;

import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;

import java.util.UUID;

public class DeletarProduto {

    private final ProdutoRepositoryInterface produtoRepository;

    public DeletarProduto(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void execute(UUID id) {
        this.produtoRepository.deleteProdutoById(id);
    }

}

package com.fiaptech2024.fastfood.core.applications.produto.usecases.deletarProduto;

import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;

public class DeletarProduto {

    private final ProdutoRepositoryInterface produtoRepository;

    public DeletarProduto(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void execute(DeletarProdutoInput input) {
        this.produtoRepository.deleteProdutoById(input.id());
    }


}

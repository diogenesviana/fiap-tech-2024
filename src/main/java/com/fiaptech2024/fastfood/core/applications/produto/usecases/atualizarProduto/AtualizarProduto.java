package com.fiaptech2024.fastfood.core.applications.produto.usecases.atualizarProduto;

import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;

import java.util.UUID;

public class AtualizarProduto {

    private final ProdutoRepositoryInterface produtoRepository;

    public AtualizarProduto(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void execute(UUID id, AtualizarProdutoInput input) {
        this.produtoRepository.update(id, input.nome(), input.preco(), input.tipoProduto());

    }


}

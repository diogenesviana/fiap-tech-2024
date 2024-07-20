package com.fiaptech2024.fastfood.core.applications.produto.usecases.SalvarProduto;

import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;

public class SalvarProduto {

    private final ProdutoRepositoryInterface produtoRepository;

    public SalvarProduto(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public SalvarProdutoOutput execute(SalvarProdutoInput input) {
        Produto produto = new Produto(input.id(), input.nome(), input.preco(), input.tipoProduto());
        produto = this.produtoRepository.saveProduto(produto);
        return new SalvarProdutoOutput(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getTipoProduto()
        );
    }
}

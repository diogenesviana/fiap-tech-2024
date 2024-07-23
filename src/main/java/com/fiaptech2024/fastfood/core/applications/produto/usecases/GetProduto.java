package com.fiaptech2024.fastfood.core.applications.produto.usecases;

import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.util.List;

public class GetProduto {

    private final ProdutoRepositoryInterface produtoRepository;

    public GetProduto(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> execute(TipoProduto tipoProduto) {
        List<Produto> produtos = this.produtoRepository.getProdutoByTipoProduto(tipoProduto);
        if (produtos.isEmpty()) {
            throw new EntityNotFoundException("Produto não encontrado");
        }
        return produtos;
    }
}

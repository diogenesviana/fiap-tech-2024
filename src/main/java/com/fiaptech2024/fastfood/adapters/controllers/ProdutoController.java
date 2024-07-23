package com.fiaptech2024.fastfood.adapters.controllers;

import com.fiaptech2024.fastfood.adapters.presenters.ProdutoPresenter;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.GetProduto;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.SalvarProduto;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.AtualizarProduto;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.DeletarProduto;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProdutoController {

    private final ProdutoRepositoryInterface produtoRepository;

    public ProdutoController(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Object salvar(String nome, BigDecimal preco, TipoProduto tipoProduto) {
        SalvarProduto salvarProduto = new SalvarProduto(this.produtoRepository);
        Produto produto = salvarProduto.execute(nome, preco, tipoProduto);
        return ProdutoPresenter.toObject(produto);
    }

    public List<Object> findByTipoProduto(TipoProduto tipoProduto) {
        GetProduto getProduto = new GetProduto(this.produtoRepository);
        List<Produto> produtos = getProduto.execute(tipoProduto);
        return ProdutoPresenter.toList(produtos);
    }

    public void deletar(UUID id) {
        DeletarProduto deletarProduto = new DeletarProduto(this.produtoRepository);
        deletarProduto.execute(id);
    }

    public void atualizar(UUID id, String nome, BigDecimal preco, TipoProduto tipoProduto) {
        AtualizarProduto atualizarProduto = new AtualizarProduto(this.produtoRepository);
        atualizarProduto.execute(id, nome, preco, tipoProduto);
    }

}

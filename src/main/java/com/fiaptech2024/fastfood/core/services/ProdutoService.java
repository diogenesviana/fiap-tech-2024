package com.fiaptech2024.fastfood.core.services;

import com.fiaptech2024.fastfood.core.applications.ports.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.ProdutoServicePort;
import com.fiaptech2024.fastfood.core.domain.Produto;
import com.fiaptech2024.fastfood.core.domain.TipoProduto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProdutoService implements ProdutoServicePort {


    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoService(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Produto save(Produto produto) {
        checkProduto(produto);
        return produtoRepositoryPort.save(produto);
    }

    @Override
    public List<Produto> findByTipoProduto(TipoProduto tipoProduto){
        return produtoRepositoryPort.findByTipoProduto(tipoProduto);
    }

    @Override
    public Produto findByProduto(String produto) {
        return produtoRepositoryPort.findByProduto(produto);
    }

    private void checkProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser vazio");
        }
        if (produto.getPreco() == null) {
            throw new IllegalArgumentException("Preço do produto não pode ser vazio");
        }
        else if (produto.getPreco().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Preço do produto não pode ser menor ou igual a zero");
        }
    }
}
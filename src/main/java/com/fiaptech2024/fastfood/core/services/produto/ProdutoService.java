package com.fiaptech2024.fastfood.core.services.produto;

import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoServicePort;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import com.fiaptech2024.fastfood.core.services.exception.RegraDeNegocioException;
import com.fiaptech2024.fastfood.core.services.produto.dtos.ProdutoDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProdutoService implements ProdutoServicePort {


    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoService(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Produto save(ProdutoDTO produtoDTO) {
        checkProduto(produtoDTO);
        validateCreate(produtoDTO);
        return produtoRepositoryPort.save(produtoDTO);
    }

    @Override
    public List<Produto> findByTipoProduto(TipoProduto tipoProduto){
        return produtoRepositoryPort.findByTipoProduto(tipoProduto);
    }

    private void checkProduto(ProdutoDTO produtoDTO) {
        if (produtoDTO.nome() == null || produtoDTO.nome().isEmpty()) {
            throw new RegraDeNegocioException("Nome do produto não pode ser vazio");
        }
        if (produtoDTO.preco() == null) {
            throw new RegraDeNegocioException("Preço do produto não pode ser vazio");
        }
        else if (produtoDTO.preco().compareTo(BigDecimal.ZERO) <= 0){
            throw new RegraDeNegocioException("Preço do produto não pode ser menor ou igual a zero");
        }


    }

    private void validateCreate(ProdutoDTO produtoDTO){
        Produto produtoDB = produtoRepositoryPort.findByProduto(produtoDTO.nome());

        if(produtoDB != null) {
            throw new RegraDeNegocioException("Produto já cadastrado");
        }
    }

    private void validateDelete(UUID id) {
        List<Produto> produtosDB = produtoRepositoryPort.findProdutosByItemsProdutos(id);
        if(!produtosDB.isEmpty()) {
            throw new RegraDeNegocioException("Produto possui itens de pedido associados, portanto não pode ser excluído");
        }
    }

    @Override
    public void deleteById(UUID id) {
        validateDelete(id);
        produtoRepositoryPort.deleteById(id);
    }

    @Override
    public void update(UUID id, ProdutoDTO produtoDTO) {
        checkProduto(produtoDTO);
        validateUpdate(id, produtoDTO);
        produtoRepositoryPort.update(id, produtoDTO);
    }

    private void validateUpdate(UUID id, ProdutoDTO produtoDTO) {
        Produto produtoDB = produtoRepositoryPort.getById(id);
        if(produtoDB == null) {
            throw new RegraDeNegocioException("Produto não cadastrado");
        }
    }


}

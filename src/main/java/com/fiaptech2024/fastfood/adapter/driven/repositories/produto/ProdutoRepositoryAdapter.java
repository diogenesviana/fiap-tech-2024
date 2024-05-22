package com.fiaptech2024.fastfood.adapter.driven.repositories.produto;


import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoRepository produtoRepository;

    private final ModelMapper modelMapper;

    @Override
    public Produto save(Produto produto) {

        ProdutoEntity entity = modelMapper.map(produto, ProdutoEntity.class);
        entity = produtoRepository.save(entity);
        return converterProdutoEntityParaProduto(entity);

    }

    @Override
    public List<Produto> findByTipoProduto(TipoProduto tipoProduto) {
        List<ProdutoEntity> produtoEntities = produtoRepository.findByTipoProduto(tipoProduto);
        return converterListProdutoEntityParaProduto(produtoEntities);
    }

    @Override
    public Produto findByProduto(String produto) {
        Optional<ProdutoEntity> produtoOptional = produtoRepository.findByNome(produto);
        return produtoOptional.map(this::converterProdutoEntityParaProduto).orElse(null);
    }

    @Override
    public Produto getById(UUID id) {
        Optional<ProdutoEntity> produtoEntity = this.produtoRepository.findById(id);
        if (produtoEntity.isEmpty()) {
            return null;
        }
        return this.converterProdutoEntityParaProduto(produtoEntity.get());
    }

    public Produto converterProdutoEntityParaProduto(ProdutoEntity produtoEntity) {
        return modelMapper.map(produtoEntity, Produto.class);
    }

    public List<Produto> converterListProdutoEntityParaProduto(List<ProdutoEntity> entity) {
        return entity.stream()
                .map(this::converterProdutoEntityParaProduto).toList();
    }


}

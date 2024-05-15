package com.fiaptech2024.fastfood.adapter.driven.repositories;


import com.fiaptech2024.fastfood.adapter.driven.entities.ProdutoEntity;
import com.fiaptech2024.fastfood.adapter.driven.repositories.ProdutoRepository;
import com.fiaptech2024.fastfood.core.applications.ports.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.Produto;
import com.fiaptech2024.fastfood.core.domain.TipoProduto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return converterProdutoEntityParaProduto(produtoRepository.findByNome(produto));
    }


    public Produto converterProdutoEntityParaProduto(ProdutoEntity produtoEntity) {
        return modelMapper.map(produtoEntity, Produto.class);
    }

    public List<Produto> converterListProdutoEntityParaProduto(List<ProdutoEntity> entity) {
        return entity.stream()
                .map(this::converterProdutoEntityParaProduto).toList();
    }


}

package com.fiaptech2024.fastfood.adapters.gateways;


import com.fiaptech2024.fastfood.application.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.application.driven.repositories.produto.ProdutoRepository;
import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProdutoGateway implements ProdutoRepositoryInterface {

    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    @Override
    public Produto saveProduto(Produto produto) {
        ProdutoEntity entity = modelMapper.map(produto, ProdutoEntity.class);
        entity = produtoRepository.save(entity);
        return modelMapper.map(entity, Produto.class);
    }

    @Override
    public List<Produto> getProdutoByTipoProduto(TipoProduto tipoProduto) {
        List<ProdutoEntity> produtoEntities = produtoRepository.findByTipoProduto(tipoProduto);
        return produtoEntities.stream()
                .map(entity -> modelMapper.map(entity, Produto.class))
                .toList();
    }

    @Override
    public void deleteProdutoById(UUID id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public void update(UUID id, String nome, BigDecimal preco, TipoProduto tipoProduto) {
        Optional<ProdutoEntity> entity = produtoRepository.findById(id);
        if(entity.isEmpty()){
            throw new EntityNotFoundException("Produto não encontrado");
        } else {
            ProdutoEntity produtoEntity = entity.get();
            produtoEntity.setNome(nome);
            produtoEntity.setPreco(preco);
            produtoEntity.setTipoProduto(tipoProduto);
            produtoRepository.save(produtoEntity);

        }
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
}

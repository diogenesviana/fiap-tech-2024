package com.fiaptech2024.fastfood.application.driven.repositories.produto;

import com.fiaptech2024.fastfood.application.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

    List<ProdutoEntity>findByTipoProduto(TipoProduto tipoProduto);

    Optional<ProdutoEntity> findByNome(String produto);

    Optional<ProdutoEntity> findById(UUID id);

    @Query("SELECT p FROM ProdutoEntity p JOIN PedidoItemEntity pi ON pi.pedido.id = p.id WHERE pi.id = :id")
    List<ProdutoEntity> findProdutosByItemsProdutos(UUID id);
}

package com.fiaptech2024.fastfood.adapter.driven.repositories;

import com.fiaptech2024.fastfood.adapter.driven.entities.ProdutoEntity;
import com.fiaptech2024.fastfood.core.domain.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

    List<ProdutoEntity>findByTipoProduto(TipoProduto tipoProduto);

    ProdutoEntity findByNome(String produto);

    Optional<ProdutoEntity> findById(UUID id);

}

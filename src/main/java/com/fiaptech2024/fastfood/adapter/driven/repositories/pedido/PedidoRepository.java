package com.fiaptech2024.fastfood.adapter.driven.repositories.pedido;

import com.fiaptech2024.fastfood.adapter.driven.entities.pedido.PedidoEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

    @Query(value = "SELECT p FROM PedidoEntity p WHERE p.pedidoStatus = :pedidoStatus")
    List<PedidoEntity> listarPorStatus(PedidoStatus pedidoStatus);

    @Query("SELECT p FROM PedidoEntity p WHERE p.pedidoStatus IN ('PRONTO', 'EM_PREPARACAO', 'RECEBIDO') ORDER BY FIELD(p.pedidoStatus, 'PRONTO', 'EM_PREPARACAO', 'RECEBIDO'), p.dataCriacao")
    List<PedidoEntity> listar();

    Optional<PedidoEntity> findById(UUID id);

    @Query("UPDATE PedidoEntity p SET p.pedidoStatus = :pedidoStatus WHERE p.id = :id")
    void atualizarStatus(UUID id, PedidoStatus pedidoStatus);
}

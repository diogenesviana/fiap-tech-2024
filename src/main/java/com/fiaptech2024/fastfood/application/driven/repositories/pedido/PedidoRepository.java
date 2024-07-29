package com.fiaptech2024.fastfood.application.driven.repositories.pedido;

import com.fiaptech2024.fastfood.application.driven.entities.pedido.PedidoEntity;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

    @Query(value = "SELECT p FROM PedidoEntity p WHERE p.statusPedido = :statusPedido")
    List<PedidoEntity> listarPorStatus(StatusPedido statusPedido);

    @Query("SELECT p FROM PedidoEntity p WHERE p.statusPedido IN ('PRONTO', 'EM_PREPARACAO', 'RECEBIDO') ORDER BY FIELD(p.statusPedido, 'PRONTO', 'EM_PREPARACAO', 'RECEBIDO'), p.dataCriacao")
    List<PedidoEntity> listar();

    Optional<PedidoEntity> findById(UUID id);
}

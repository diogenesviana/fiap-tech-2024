package com.fiaptech2024.fastfood.adapter.driven.repositories.pedido;

import com.fiaptech2024.fastfood.adapter.driven.entities.pedido.PedidoEntity;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

    @Query(value = "SELECT p FROM PedidoEntity p WHERE p.pedidoStatus = :pedidoStatus")
    List<PedidoEntity> listarPorStatus(PedidoStatus pedidoStatus);

    @Modifying
    @Query("UPDATE PedidoEntity SET pedidoStatus=:pedidoStatus, statusPagamento=:statusPagamento WHERE id=:id")
    public void realizarPagamento(@Param("id") UUID id, @Param("pedidoStatus") PedidoStatus pedidoStatus, @Param("statusPagamento") StatusPagamento statusPagamento);
}

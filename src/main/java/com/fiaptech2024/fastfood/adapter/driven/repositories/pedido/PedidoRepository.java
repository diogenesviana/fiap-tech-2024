package com.fiaptech2024.fastfood.adapter.driven.repositories.pedido;

import com.fiaptech2024.fastfood.adapter.driven.entities.pedido.PedidoEntity;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoEntity, UUID> {

    @Query(value = "SELECT p FROM PedidoEntity p WHERE p.pedidoStatus = :pedidoStatus")
    List<PedidoEntity> listarPorStatus(PedidoStatus pedidoStatus);

}

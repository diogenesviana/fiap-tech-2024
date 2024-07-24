package com.fiaptech2024.fastfood.application.driven.repositories.pedido;

import com.fiaptech2024.fastfood.application.driven.entities.pedido.PedidoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoItemRepository extends JpaRepository<PedidoItemEntity, UUID> {

}

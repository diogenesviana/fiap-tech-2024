package com.fiaptech2024.fastfood.adapter.driven.entities;

import com.fiaptech2024.fastfood.core.domain.enums.PedidoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PEDIDO_ITEM")
public class PedidoItemEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private int quantidade;

    @ManyToOne
    private PedidoEntity pedido;
}

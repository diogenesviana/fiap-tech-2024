package com.fiaptech2024.fastfood.adapter.driven.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private ProdutoEntity produto;
}

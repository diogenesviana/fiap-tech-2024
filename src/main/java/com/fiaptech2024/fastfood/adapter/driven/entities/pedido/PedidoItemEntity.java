package com.fiaptech2024.fastfood.adapter.driven.entities.pedido;

import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
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
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;
}

package com.fiaptech2024.fastfood.adapter.driven.entities;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoEntity {

    @Id
    private UUID id;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @ManyToOne
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "id")
    private List<PedidoItemEntity> itens;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant dataCriacao;
}

package com.fiaptech2024.fastfood.adapter.driven.entities;

import com.fiaptech2024.fastfood.core.domain.TipoProduto;
import com.fiaptech2024.fastfood.core.domain.enums.PedidoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class PedidoEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private PedidoStatus pedidoStatus;

    @ManyToOne
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "id")
    private List<PedidoItemEntity> itens;
}

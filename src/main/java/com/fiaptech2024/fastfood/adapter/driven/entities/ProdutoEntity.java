package com.fiaptech2024.fastfood.adapter.driven.entities;

import com.fiaptech2024.fastfood.core.domain.TipoProduto;
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
@Table(name = "TB_PRODUTO")
public class ProdutoEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String nome;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private TipoProduto tipoProduto;

    @OneToMany(mappedBy = "id")
    private List<PedidoItemEntity> pedidosItens;
}

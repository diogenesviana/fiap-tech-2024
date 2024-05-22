package com.fiaptech2024.fastfood.adapter.driven.repositories.pedido;

import com.fiaptech2024.fastfood.adapter.driven.entities.ClienteEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.PedidoEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.PedidoItemEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.ProdutoEntity;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private PedidoRepository pedidoRepository;

    private PedidoItemRepository pedidoItemRepository;

    private final ModelMapper modelMapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(pedido.getClienteId());

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedido.getId());
        pedidoEntity.setPedidoStatus(pedido.getStatus());
        pedidoEntity.setStatusPagamento(pedido.getStatusPagamento());
        pedidoEntity.setPreco(pedido.getValor());
        pedidoEntity.setCliente(clienteEntity);
        this.pedidoRepository.save(pedidoEntity);

        for (PedidoItem pedidoItem : pedido.getItems()) {
            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setId(pedidoItem.getItemId());

            PedidoItemEntity pedidoItemEntity = new PedidoItemEntity();
            pedidoItemEntity.setQuantidade(pedidoItem.getQuantidade());
            pedidoItemEntity.setPedido(pedidoEntity);
            pedidoItemEntity.setProduto(produtoEntity);
            this.pedidoItemRepository.save(pedidoItemEntity);
        }

        return pedido;
    }

}
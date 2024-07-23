package com.fiaptech2024.fastfood.adapter.gateway;

import com.fiaptech2024.fastfood.adapter.driven.entities.cliente.ClienteEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.pedido.PedidoEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.pedido.PedidoItemEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.adapter.driven.repositories.pedido.PedidoItemRepository;
import com.fiaptech2024.fastfood.adapter.driven.repositories.pedido.PedidoRepository;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PedidoRepositoryDatabase implements PedidoRepositoryInterace {

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

    @Override
    public List<Pedido> listarPorStatus(PedidoStatus pedidoStatus) {
        return this.dtoToEntidade(this.pedidoRepository.listarPorStatus(pedidoStatus));
    }

    @Override
    public List<Pedido> listar() {
        return this.dtoToEntidade(this.pedidoRepository.listar());
    }

    private List<Pedido> dtoToEntidade(List<PedidoEntity> listaDePedidos) {
        List<Pedido> listaDePedidosDTO = new ArrayList<>();
        for (PedidoEntity pedidoEntity : listaDePedidos) {
            Pedido pedido = new Pedido(
                    pedidoEntity.getId(),
                    pedidoEntity.getCliente().getId(),
                    pedidoEntity.getPedidoStatus(),
                    pedidoEntity.getStatusPagamento(),
                    pedidoEntity.getDataCriacao()
            );
            for (PedidoItemEntity pedidoItemEntity : pedidoEntity.getItens()) {
                PedidoItem pedidoItem = new PedidoItem(pedidoItemEntity.getProduto().getId(),
                        pedidoItemEntity.getProduto().getPreco(),
                        pedidoItemEntity.getQuantidade()
                );
                pedido.addItem(pedidoItem);
            }
            listaDePedidosDTO.add(pedido);
        }
        return listaDePedidosDTO;
    }

}

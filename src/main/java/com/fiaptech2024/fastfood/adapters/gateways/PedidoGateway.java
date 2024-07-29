package com.fiaptech2024.fastfood.adapters.gateways;

import com.fiaptech2024.fastfood.application.driven.entities.cliente.ClienteEntity;
import com.fiaptech2024.fastfood.application.driven.entities.pedido.PedidoEntity;
import com.fiaptech2024.fastfood.application.driven.entities.pedido.PedidoItemEntity;
import com.fiaptech2024.fastfood.application.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.application.driven.repositories.pedido.PedidoItemRepository;
import com.fiaptech2024.fastfood.application.driven.repositories.pedido.PedidoRepository;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PedidoGateway implements PedidoRepositoryInterace {

    private PedidoRepository pedidoRepository;

    private PedidoItemRepository pedidoItemRepository;

    private final ModelMapper modelMapper;

    @Override
    public Pedido criarPedido(Pedido pedido) {

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(pedido.getClienteId());

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedido.getId());
        pedidoEntity.setStatusPedido(pedido.getStatusPedido());
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
    public List<Pedido> listarPorStatus(StatusPedido statusPedido) {
        return this.listaDtoToEntidade(this.pedidoRepository.listarPorStatus(statusPedido));
    }

    @Override
    public List<Pedido> listar() {
        return this.listaDtoToEntidade(this.pedidoRepository.listar());
    }

    @Override
    public Pedido getById(UUID id) {
        Optional<PedidoEntity> entity = this.pedidoRepository.findById(id);
        if (entity.isEmpty()) {
            return null;
        }
        return this.dtoToEntidade(entity.get());
    }

    @Override
    public Pedido atualizarStatus(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(pedido.getId());
        pedidoEntity.setStatusPedido(pedido.getStatusPedido());
        pedidoEntity.setStatusPagamento(pedido.getStatusPagamento());
        pedidoEntity.setPreco(pedido.getValor());

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(pedido.getClienteId());
        pedidoEntity.setCliente(clienteEntity);

        List<PedidoItemEntity> pedidoItemEntities = new ArrayList<>();
        for (PedidoItem pedidoItem : pedido.getItems()) {
            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setId(pedidoItem.getItemId());

            PedidoItemEntity pedidoItemEntity = new PedidoItemEntity();
            pedidoItemEntity.setQuantidade(pedidoItem.getQuantidade());
            pedidoItemEntity.setPedido(pedidoEntity);
            pedidoItemEntity.setProduto(produtoEntity);
            pedidoItemEntities.add(pedidoItemEntity);
        }
        pedidoEntity.setItems(pedidoItemEntities);
        pedidoEntity = pedidoRepository.save(pedidoEntity);
        return this.dtoToEntidade(pedidoEntity);
    }

    private List<Pedido> listaDtoToEntidade(List<PedidoEntity> listaDePedidos) {
        List<Pedido> listaDePedidosDTO = new ArrayList<>();
        for (PedidoEntity pedidoEntity : listaDePedidos) {
            listaDePedidosDTO.add(this.dtoToEntidade(pedidoEntity));
        }
        return listaDePedidosDTO;
    }

    private Pedido dtoToEntidade(PedidoEntity pedidoEntity) {
        Pedido pedido = new Pedido(
                pedidoEntity.getId(),
                pedidoEntity.getCliente().getId(),
                pedidoEntity.getStatusPedido(),
                pedidoEntity.getStatusPagamento(),
                pedidoEntity.getDataCriacao()
        );
        for (PedidoItemEntity pedidoItemEntity : pedidoEntity.getItems()) {
            PedidoItem pedidoItem = new PedidoItem(pedidoItemEntity.getProduto().getId(),
                    pedidoItemEntity.getProduto().getPreco(),
                    pedidoItemEntity.getQuantidade()
            );
            pedido.addItem(pedidoItem);
        }
        return pedido;
    }
}

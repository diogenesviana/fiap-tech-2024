package com.fiaptech2024.fastfood.core.services.pedido;

import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;
import com.fiaptech2024.fastfood.core.services.exception.RegraDeNegocioException;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceDto;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceItemDto;
import com.fiaptech2024.fastfood.core.services.exception.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public UUID criarPedido(PedidoServiceDto pedidoServiceDto) {
        Pedido pedido = new Pedido(UUID.randomUUID(), pedidoServiceDto.cliente_id(), PedidoStatus.RECEBIDO, StatusPagamento.AGUARDANDO);
        for (PedidoServiceItemDto pedidoServiceItemDto : pedidoServiceDto.itens()) {
            Produto produto = this.produtoRepositoryPort.getById(pedidoServiceItemDto.item_id());
            if (produto == null) {
                throw new EntityNotFoundException("Item do pedido não encontrado");
            }
            pedido.addItem(new PedidoItem(pedidoServiceItemDto.item_id(), produto.getPreco(), pedidoServiceItemDto.quantidade()));
        }
        this.check(pedido);
        this.pedidoRepositoryPort.criarPedido(pedido);
        return pedido.getId();
    }

    private void check(Pedido pedido) {
        if (pedido.getItems().isEmpty()) {
            throw new RegraDeNegocioException("O pedido deve contar um ou mais itens");
        }
        for (PedidoItem pedidoItem : pedido.getItems()) {
            if (pedidoItem.getQuantidade() < 1) {
                throw new RegraDeNegocioException("A quantidade do item deve ser maior que 0");
            }
        }
    }

    public List<PedidoDTO> listar(PedidoStatus pedidoStatus){
        return pedidoRepositoryPort.listar(pedidoStatus);
    }

}
package com.fiaptech2024.fastfood.core.services.pedido;

import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import com.fiaptech2024.fastfood.core.domain.Produto;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceDto;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceItemDto;
import com.fiaptech2024.fastfood.core.services.exception.EntityNotFoundException;

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
        Pedido pedido = new Pedido(UUID.randomUUID(), pedidoServiceDto.cliente_id(), PedidoStatus.RECEBIDO);
        for (PedidoServiceItemDto pedidoServiceItemDto : pedidoServiceDto.itens()) {
            Produto produto = this.produtoRepositoryPort.getById(pedidoServiceItemDto.item_id());
            if (produto == null) {
                throw new EntityNotFoundException("Item do pedido não encontrado");
            }
            pedido.addItem(new PedidoItem(pedidoServiceItemDto.item_id(), produto.getPreco(), pedidoServiceItemDto.quantidade()));
        }
        this.pedidoRepositoryPort.criarPedido(pedido);
        return pedido.getId();
    }

    private void check(Pedido pedido) {

//        if(!isValidCPF(cliente.getCpf())){
//            throw new RegraDeNegocioException("CPF inválido");
//        }
//
//        if(clienteRepositoryPort.existsClienteByCpf(cliente.getCpf())){
//            throw new RegraDeNegocioException("CPF já cadastrado");
//        }
//
//        if (!isValidEmail(cliente.getEmail())){
//            throw new RegraDeNegocioException("Email inválido");
//        }
    }

}
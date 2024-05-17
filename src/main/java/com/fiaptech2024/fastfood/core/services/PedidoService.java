package com.fiaptech2024.fastfood.core.services;

import com.fiaptech2024.fastfood.core.applications.ports.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.PedidoServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.ProdutoServicePort;
import com.fiaptech2024.fastfood.core.domain.Pedido;
import com.fiaptech2024.fastfood.core.domain.PedidoItem;
import com.fiaptech2024.fastfood.core.domain.Produto;
import com.fiaptech2024.fastfood.core.domain.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.dtos.PedidoServiceDto;
import com.fiaptech2024.fastfood.core.services.dtos.PedidoServiceItemDto;
import com.fiaptech2024.fastfood.core.services.exception.EntityNotFoundException;

import java.util.UUID;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

//    private final ProdutoServicePort produtoServicePort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort/*, ProdutoServicePort produtoServicePort*/) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
//        this.produtoServicePort = produtoServicePort;
    }

    @Override
    public UUID save(PedidoServiceDto pedidoServiceDto) {
        Pedido pedido = new Pedido(UUID.randomUUID(), pedidoServiceDto.cliente_id(), PedidoStatus.RECEBIDO);
        for (PedidoServiceItemDto pedidoServiceItemDto : pedidoServiceDto.itens()) {
            Produto produto = null;
            if (produto == null) {
                throw new EntityNotFoundException("Item do pedido não encontrado");
            }
            pedido.addItem(new PedidoItem(UUID.randomUUID(), pedidoServiceItemDto.item_id(), produto.getPreco(), pedidoServiceItemDto.quantidade()));
        }
        this.pedidoRepositoryPort.save(pedido);
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
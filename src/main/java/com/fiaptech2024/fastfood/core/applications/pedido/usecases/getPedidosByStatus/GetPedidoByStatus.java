package com.fiaptech2024.fastfood.core.applications.pedido.usecases.getPedidosByStatus;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class GetPedidoByStatus {

    private final PedidoRepositoryInterace pedidoRepository;
    private final ClienteRepositoryInterface clienteRepository;
    private final ProdutoRepositoryInterface produtoRepository;

    public GetPedidoByStatus(PedidoRepositoryInterace pedidoRepository, ClienteRepositoryInterface clienteRepository, ProdutoRepositoryInterface produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<GetPedidoByStatusOutput> execute(GetPedidoByStatusInput input) {
        List<Pedido> pedidos = this.pedidoRepository.listarPorStatus(input.pedidoStatus());
        List<GetPedidoByStatusOutput> pedidosOutput = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            Cliente cliente = this.clienteRepository.getClienteById(pedido.getClienteId());
            List<GetPedidoByStatusItemOutput> outputItens = new ArrayList<>();
            for (PedidoItem pedidoItem : pedido.getItems()) {
                Produto produto = this.produtoRepository.getById(pedidoItem.getItemId());
                outputItens.add(new GetPedidoByStatusItemOutput(pedidoItem.getItemId(), produto.getNome(), pedidoItem.getQuantidade(), pedido.getValor()));
            }
            pedidosOutput.add(
                    new GetPedidoByStatusOutput(
                            pedido.getId(),
                            pedido.getClienteId(),
                            cliente.getNome(),
                            pedido.getStatus(),
                            pedido.getStatusPagamento(),
                            pedido.getValor(),
                            pedido.getDataCriacao(),
                            outputItens
                    )
            );
        }
        return pedidosOutput;
    }

}

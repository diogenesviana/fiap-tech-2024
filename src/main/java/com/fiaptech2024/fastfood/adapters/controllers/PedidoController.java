package com.fiaptech2024.fastfood.adapters.controllers;

import com.fiaptech2024.fastfood.adapters.presenters.PedidoPresenter;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.GetPedidos;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.GetPedidosByStatus;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;

import java.util.List;

public class PedidoController {

    private final PedidoRepositoryInterace pedidoRepository;
    private final ClienteRepositoryInterface clienteRepository;
    private final ProdutoRepositoryInterface produtoRepository;

    public PedidoController(PedidoRepositoryInterace pedidoRepository, ClienteRepositoryInterface clienteRepository, ProdutoRepositoryInterface produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Object> listar() {
        GetPedidos getPedidos = new GetPedidos(this.pedidoRepository);
        List<Pedido> pedidos = getPedidos.execute();
        return PedidoPresenter.toList(pedidos);
    }

    public List<Object> listarPorStatus(PedidoStatus pedidoStatus) {
        GetPedidosByStatus getPedidosByStatus = new GetPedidosByStatus(this.pedidoRepository);
        List<Pedido> pedidos = getPedidosByStatus.execute(pedidoStatus);
        return PedidoPresenter.toList(pedidos);
    }

}

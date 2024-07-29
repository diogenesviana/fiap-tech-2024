package com.fiaptech2024.fastfood.adapters.controllers;

import com.fiaptech2024.fastfood.adapters.presenters.PedidoPresenter;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.*;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedido;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedidoInput;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPedido;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;

import java.util.List;
import java.util.UUID;

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

    public List<Object> listarPorStatus(StatusPedido statusPedido) {
        GetPedidosByStatus getPedidosByStatus = new GetPedidosByStatus(this.pedidoRepository);
        List<Pedido> pedidos = getPedidosByStatus.execute(statusPedido);
        return PedidoPresenter.toList(pedidos);
    }

    public Object criarPedido(CriarPedidoInput input) {
        CriarPedido criarPedido = new CriarPedido(this.pedidoRepository, this.clienteRepository, this.produtoRepository);
        return PedidoPresenter.toObject(criarPedido.execute(input));
    }

    public Object pagamentoAprovado(UUID id) {
        GetPedido getPedido = new GetPedido(this.pedidoRepository);
        return PedidoPresenter.toObjectStatusPedido(getPedido.execute(id));
    }

    public Object atualizarStatusPedido(UUID id, StatusPedido statusPedido) {
        AtualizarStatusPedido atualizarStatusPedido = new AtualizarStatusPedido(this.pedidoRepository);
        return atualizarStatusPedido.execute(id, statusPedido);
    }

    public Object atualizarStatusPagamento(UUID id, StatusPagamento statusPagamento) {
        AtualizarStatusPagamento atualizarStatusPagamento = new AtualizarStatusPagamento(this.pedidoRepository);
        return PedidoPresenter.toObjectStatusPedido(atualizarStatusPagamento.execute(id, statusPagamento));
    }

}

package com.fiaptech2024.fastfood.core.services.pedido;

import com.fiaptech2024.fastfood.core.applications.ports.cliente.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;
import com.fiaptech2024.fastfood.core.services.exception.RegraDeNegocioException;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceCriarPedidoDto;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceCriarPedidoItemDto;
import com.fiaptech2024.fastfood.core.services.exception.EntityNotFoundException;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class PedidoService implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    private final ProdutoRepositoryPort produtoRepositoryPort;

    private final ClienteRepositoryPort clienteRepositoryPort;

    public PedidoService(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort, ClienteRepositoryPort clienteRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.produtoRepositoryPort = produtoRepositoryPort;
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public void criarPedido(PedidoServiceCriarPedidoDto pedidoServiceCriarPedidoDto) {
        Cliente cliente = this.clienteRepositoryPort.getClienteById(pedidoServiceCriarPedidoDto.cliente_id());
        if (cliente == null) {
            throw new RegraDeNegocioException("Cliente não encontrado");
        }
        Pedido pedido = new Pedido(UUID.randomUUID(), pedidoServiceCriarPedidoDto.cliente_id(), PedidoStatus.FINALIZADO, StatusPagamento.PAGO, Instant.now());
        for (PedidoServiceCriarPedidoItemDto pedidoServiceItemDto : pedidoServiceCriarPedidoDto.itens()) {
            Produto produto = this.produtoRepositoryPort.getById(pedidoServiceItemDto.item_id());
            if (produto == null) {
                throw new RegraDeNegocioException("Item do pedido não encontrado");
            }
            pedido.addItem(new PedidoItem(pedidoServiceItemDto.item_id(), produto.getPreco(), pedidoServiceItemDto.quantidade()));
        }
        this.check(pedido);
        this.pedidoRepositoryPort.criarPedido(pedido);
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

    public List<PedidoDTO> listar(PedidoStatus pedidoStatus) {
        return pedidoRepositoryPort.listar(pedidoStatus);
    }

}
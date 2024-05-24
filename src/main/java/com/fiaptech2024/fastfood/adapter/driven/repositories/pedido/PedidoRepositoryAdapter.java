package com.fiaptech2024.fastfood.adapter.driven.repositories.pedido;

import com.fiaptech2024.fastfood.adapter.driven.entities.cliente.ClienteEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.pedido.PedidoEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.pedido.PedidoItemEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.produto.ProdutoEntity;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPagamento;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;
import com.fiaptech2024.fastfood.core.domain.pedido.PedidoItem;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoItemDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public List<PedidoDTO> listar(PedidoStatus pedidoStatus) {
        List<PedidoEntity> listaDePedidos = pedidoRepository.listarPorStatus(pedidoStatus);
        List<PedidoDTO> listaDePedidosDTO = new ArrayList<>();
        for (PedidoEntity pedidoEntity : listaDePedidos) {
            PedidoDTO pedidoDTO = new PedidoDTO(pedidoEntity.getId(),
                    pedidoEntity.getPreco(),
                    pedidoEntity.getPedidoStatus(),
                    pedidoEntity.getStatusPagamento(),
                    pedidoEntity.getCliente().getNome(),
                    pedidoEntity.getItens().stream()
                            .map(pedidoItemEntity -> new PedidoItemDTO(pedidoItemEntity.getId(),
                                    pedidoItemEntity.getQuantidade(),
                                    pedidoItemEntity.getProduto().getNome())).toList(),
                    pedidoEntity.getDataCriacao());
            listaDePedidosDTO.add(pedidoDTO);

        }
        return listaDePedidosDTO;
    }

    @Override
    public Pedido getById(UUID id) {
        Optional<PedidoEntity> pedidoEntity = this.pedidoRepository.findById(id);
        if (pedidoEntity.isEmpty()) {
            return null;
        }
        Pedido pedido = new Pedido(
                pedidoEntity.get().getId(),
                pedidoEntity.get().getCliente().getId(),
                pedidoEntity.get().getPedidoStatus(),
                pedidoEntity.get().getStatusPagamento()
        );
        for (PedidoItemEntity pedidoItemEntity : pedidoEntity.get().getItens()) {
            pedido.addItem(new PedidoItem(
                    pedidoItemEntity.getId(),
                    pedidoItemEntity.getProduto().getPreco(),
                    pedidoItemEntity.getQuantidade()
            ));
        }
        return pedido;
    }

    @Transactional
    @Override
    public void realizarPagamento(Pedido pedido) {
        this.pedidoRepository.realizarPagamento(pedido.getId(), PedidoStatus.FINALIZADO, StatusPagamento.PAGO);
    }
}
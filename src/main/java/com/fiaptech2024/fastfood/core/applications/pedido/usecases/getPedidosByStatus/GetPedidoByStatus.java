package com.fiaptech2024.fastfood.core.applications.pedido.usecases.getPedidosByStatus;

import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.domain.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class GetPedidoByStatus {

    private final PedidoRepositoryInterace pedidoRepository;

    public GetPedidoByStatus(PedidoRepositoryInterace pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<GetPedidoByStatusOutput> execute(GetPedidoByStatusInput input) {
        List<Pedido> pedidos = this.pedidoRepository.listar(input.pedidoStatus());
        List<GetPedidoByStatusOutput> pedidosOutput = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            pedidosOutput.add(new GetPedidoByStatusOutput(pedido.getId()));
        }
        return pedidosOutput;
    }

}

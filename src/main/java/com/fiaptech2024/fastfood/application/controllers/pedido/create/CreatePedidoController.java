package com.fiaptech2024.fastfood.application.controllers.pedido.create;

import com.fiaptech2024.fastfood.adapters.controllers.PedidoController;
import com.fiaptech2024.fastfood.application.controllers.pedido.create.requests.PedidoCreateItemRequest;
import com.fiaptech2024.fastfood.application.controllers.pedido.create.requests.PedidoCreateRequest;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedidoInput;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedidoItemInput;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class CreatePedidoController {

    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    @Operation(tags = "Pedidos")
    public ResponseEntity<Object> create(@RequestBody PedidoCreateRequest request) {
        PedidoController pedidoController = new PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        List<CriarPedidoItemInput> inputItens = new ArrayList<>();
        for (PedidoCreateItemRequest itemPedido : request.items()) {
            inputItens.add(new CriarPedidoItemInput(itemPedido.item_id(), itemPedido.quantidade()));
        }
        CriarPedidoInput input = new CriarPedidoInput(request.cliente_id(), inputItens);
        return new ResponseEntity<>(pedidoController.criarPedido(input), HttpStatus.CREATED);
    }

}

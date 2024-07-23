package com.fiaptech2024.fastfood.adapter.driver.controllers.pedido;

import com.fiaptech2024.fastfood.adapter.driver.controllers.pedido.requests.PedidoCreateRequest;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedidoInput;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedidoItemInput;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedido")
@AllArgsConstructor
public class PedidoController {

    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PedidoCreateRequest request) {
        com.fiaptech2024.fastfood.adapters.controllers.PedidoController pedidoController = new com.fiaptech2024.fastfood.adapters.controllers.PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        List<CriarPedidoItemInput> inputItens = new ArrayList<>();
        for (PedidoCreateRequest.ItemPedido itemPedido : request.itens()) {
            inputItens.add(new CriarPedidoItemInput(itemPedido.item_id(), itemPedido.quantidade()));
        }
        CriarPedidoInput input = new CriarPedidoInput(request.cliente_id(), inputItens);
        return new ResponseEntity<>(pedidoController.criarPedido(input), HttpStatus.CREATED);
    }

    @GetMapping("/{pedidoStatus}")
    public ResponseEntity<List<Object>> listarPorStatus(@PathVariable("pedidoStatus") PedidoStatus pedidoStatus) {
        com.fiaptech2024.fastfood.adapters.controllers.PedidoController pedidoController = new com.fiaptech2024.fastfood.adapters.controllers.PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        return new ResponseEntity<>(pedidoController.listarPorStatus(pedidoStatus), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Object>> listar() {
        com.fiaptech2024.fastfood.adapters.controllers.PedidoController pedidoController = new com.fiaptech2024.fastfood.adapters.controllers.PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        return new ResponseEntity<>(pedidoController.listar(), HttpStatus.OK);
    }

}
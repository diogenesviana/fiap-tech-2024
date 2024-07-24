package com.fiaptech2024.fastfood.application.controllers.pedido.listar;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class ListarPedidoController {

    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @GetMapping
    @Operation(tags = "Pedidos")
    public ResponseEntity<List<Object>> listar() {
        com.fiaptech2024.fastfood.adapters.controllers.PedidoController pedidoController = new com.fiaptech2024.fastfood.adapters.controllers.PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        return new ResponseEntity<>(pedidoController.listar(), HttpStatus.OK);
    }

}

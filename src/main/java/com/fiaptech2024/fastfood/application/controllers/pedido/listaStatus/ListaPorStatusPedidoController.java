package com.fiaptech2024.fastfood.application.controllers.pedido.listaStatus;

import com.fiaptech2024.fastfood.adapters.controllers.PedidoController;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.StatusPedido;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class ListaPorStatusPedidoController {

    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @GetMapping("/{pedidoStatus}")
    @Operation(tags = "Pedidos")
    public ResponseEntity<List<Object>> listarPorStatus(@PathVariable("pedidoStatus") StatusPedido statusPedido) {
        PedidoController pedidoController = new PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        return new ResponseEntity<>(pedidoController.listarPorStatus(statusPedido), HttpStatus.OK);
    }

}

package com.fiaptech2024.fastfood.application.controllers.pedido.atualizarStatus;

import com.fiaptech2024.fastfood.adapters.controllers.PedidoController;
import com.fiaptech2024.fastfood.application.controllers.pedido.atualizarStatus.requests.AtualizarStatusRequest;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class AtualizarStatusPedidoController {

    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping("/atualizar-status/{id}")
    @Operation(tags = "Pedidos")
    public ResponseEntity<Produto> atualizarStatus(@PathVariable("id") UUID id, @RequestBody AtualizarStatusRequest request) {
        PedidoController pedidoController = new PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        pedidoController.atualizarStatusPedido(id, request.pedidoStatus());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
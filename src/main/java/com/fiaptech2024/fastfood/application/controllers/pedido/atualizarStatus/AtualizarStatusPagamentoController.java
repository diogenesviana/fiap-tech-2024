package com.fiaptech2024.fastfood.application.controllers.pedido.atualizarStatus;

import com.fiaptech2024.fastfood.adapters.controllers.PedidoController;
import com.fiaptech2024.fastfood.application.controllers.pedido.atualizarStatus.requests.AtualizarStatusPagamentoRequest;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("pagamentos")
@AllArgsConstructor
public class AtualizarStatusPagamentoController {


    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    @Operation(tags = "Pagamentos", summary = "Webhook de atualização do status do pagamento")
    public ResponseEntity<Object> atualizarStatusPagamento(@RequestBody AtualizarStatusPagamentoRequest request) {
        PedidoController pedidoController = new PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        var pedido = pedidoController.atualizarStatusPagamento(request.id(), request.statusPagamento());
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}

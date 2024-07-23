package com.fiaptech2024.fastfood.adapter.driver.controllers.pedido;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedido;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedidoInput;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.criarPedido.CriarPedidoOutput;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
@AllArgsConstructor
public class PedidoController {

    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    public ResponseEntity <CriarPedidoOutput> create(@RequestBody CriarPedidoInput input) {
        CriarPedido criarPedido = new CriarPedido(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        CriarPedidoOutput output = criarPedido.execute(input);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @GetMapping("/{pedidoStatus}")
    public ResponseEntity <List<Object>> listarPorStatus(@PathVariable("pedidoStatus") PedidoStatus pedidoStatus){
        com.fiaptech2024.fastfood.adapters.controllers.PedidoController pedidoController = new com.fiaptech2024.fastfood.adapters.controllers.PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        return new ResponseEntity<>(pedidoController.listarPorStatus(pedidoStatus), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List<Object>> listar() {
        com.fiaptech2024.fastfood.adapters.controllers.PedidoController pedidoController = new com.fiaptech2024.fastfood.adapters.controllers.PedidoController(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        return new ResponseEntity<>(pedidoController.listar(), HttpStatus.OK);
    }

}
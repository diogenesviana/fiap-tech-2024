package com.fiaptech2024.fastfood.adapter.driver.controllers.pedido;

import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente.GetCliente;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente.GetClienteInput;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente.GetClienteOutput;
import com.fiaptech2024.fastfood.core.applications.pedido.repositories.PedidoRepositoryInterace;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.CriarPedido;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.CriarPedidoInput;
import com.fiaptech2024.fastfood.core.applications.pedido.usecases.CriarPedidoOutput;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoServicePort;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceCriarPedidoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
@AllArgsConstructor
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    private final PedidoRepositoryInterace pedidoRepositoryInterace;
    private final ClienteRepositoryInterface clienteRepositoryInterface;
    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    public ResponseEntity create(@RequestBody CriarPedidoInput input) {
        CriarPedido criarPedido = new CriarPedido(this.pedidoRepositoryInterace, this.clienteRepositoryInterface, this.produtoRepositoryInterface);
        CriarPedidoOutput output = criarPedido.execute(input);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /*@PostMapping
    public ResponseEntity create(@RequestBody PedidoServiceCriarPedidoDto pedidoServiceDto) {
        this.pedidoServicePort.criarPedido(pedidoServiceDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }*/

    @GetMapping("/{pedidoStatus}")
    public ResponseEntity <List<PedidoDTO>> listar(@PathVariable("pedidoStatus") PedidoStatus pedidoStatus){
        return new ResponseEntity<>(pedidoServicePort.listar(pedidoStatus), HttpStatus.OK);
    }

}
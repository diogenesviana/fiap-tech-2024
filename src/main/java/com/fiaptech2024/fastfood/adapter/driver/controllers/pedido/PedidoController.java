package com.fiaptech2024.fastfood.adapter.driver.controllers.pedido;

import com.fiaptech2024.fastfood.core.domain.pedido.enums.PedidoStatus;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoDTO;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoServicePort;
import com.fiaptech2024.fastfood.core.services.pedido.dtos.PedidoServiceCriarPedidoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("pedido")
@AllArgsConstructor
public class PedidoController {

    private final PedidoServicePort pedidoServicePort;

    @PostMapping
    public ResponseEntity<Map<String, UUID>> create(@RequestBody PedidoServiceCriarPedidoDto pedidoServiceDto) {
        UUID uuid = this.pedidoServicePort.criarPedido(pedidoServiceDto);
        Map<String, UUID> response = new HashMap<>();
        response.put("id", uuid);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{pedidoStatus}")
    public ResponseEntity <List<PedidoDTO>> listar(@PathVariable("pedidoStatus") PedidoStatus pedidoStatus){
        return new ResponseEntity<>(pedidoServicePort.listar(pedidoStatus), HttpStatus.OK);
    }

}
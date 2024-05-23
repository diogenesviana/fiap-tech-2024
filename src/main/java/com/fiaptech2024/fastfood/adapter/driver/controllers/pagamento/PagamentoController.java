package com.fiaptech2024.fastfood.adapter.driver.controllers.pagamento;

import com.fiaptech2024.fastfood.core.applications.ports.pagamento.PagamentoServicePort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("pagamento")
@AllArgsConstructor
public class PagamentoController {

    private final PagamentoServicePort pagamentoServicePort;

    @PostMapping("/checkout/{UUID}")
    public ResponseEntity create(@RequestParam("uuid") UUID uuid) {
        this.pagamentoServicePort.solicitarPagamento(uuid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

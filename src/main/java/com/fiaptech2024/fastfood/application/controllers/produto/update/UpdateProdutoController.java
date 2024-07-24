package com.fiaptech2024.fastfood.application.controllers.produto.update;

import com.fiaptech2024.fastfood.adapters.controllers.ProdutoController;
import com.fiaptech2024.fastfood.application.controllers.produto.update.requests.ProdutoUpdateRequest;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class UpdateProdutoController {

    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PutMapping("/{id}")
    @Operation(tags = "Produtos")
    public ResponseEntity<Produto> update(@PathVariable("id") UUID id, @RequestBody ProdutoUpdateRequest request) {
        ProdutoController produtoController = new ProdutoController(this.produtoRepositoryInterface);
        produtoController.atualizar(id, request.nome(), request.preco(), request.tipoProduto());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

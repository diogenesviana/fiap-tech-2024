package com.fiaptech2024.fastfood.application.controllers.produto.create;

import com.fiaptech2024.fastfood.adapters.controllers.ProdutoController;
import com.fiaptech2024.fastfood.application.controllers.produto.create.requests.ProdutoCreateRequest;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class CreateProdutoController {

    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    @Operation(tags = "Produtos")
    public ResponseEntity<Object> create(@RequestBody ProdutoCreateRequest request) {
        ProdutoController produtoController = new ProdutoController(this.produtoRepositoryInterface);
        return new ResponseEntity<>(produtoController.salvar(request.nome(), request.preco(), request.tipoProduto()), HttpStatus.CREATED);
    }


}

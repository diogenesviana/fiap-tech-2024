package com.fiaptech2024.fastfood.application.controllers.produto.findTipoProduto;

import com.fiaptech2024.fastfood.adapters.controllers.ProdutoController;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class FindTipoProdutoProdutoController {

    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @GetMapping("/tipo/{tipoProduto}")
    @Operation(tags = "Produtos")
    public ResponseEntity<Object> findByTipoProduto(@PathVariable("tipoProduto") TipoProduto tipoProduto) {
        ProdutoController produtoController = new ProdutoController(this.produtoRepositoryInterface);
        return new ResponseEntity<>(produtoController.findByTipoProduto(tipoProduto), HttpStatus.OK);
    }

}

package com.fiaptech2024.fastfood.adapter.driver.controllers.produto;

import com.fiaptech2024.fastfood.adapter.driver.controllers.produto.requests.ProdutoCreateRequest;
import com.fiaptech2024.fastfood.adapter.driver.controllers.produto.requests.ProdutoUpdateRequest;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody ProdutoCreateRequest request) {
        com.fiaptech2024.fastfood.adapters.controllers.ProdutoController produtoController = new com.fiaptech2024.fastfood.adapters.controllers.ProdutoController(this.produtoRepositoryInterface);
        return new ResponseEntity<>(produtoController.salvar(request.nome(), request.preco(), request.tipoProduto()), HttpStatus.CREATED);
    }

    @GetMapping("/tipo/{tipoProduto}")
    public ResponseEntity<Object> findByTipoProduto(@PathVariable("tipoProduto") TipoProduto tipoProduto) {
        com.fiaptech2024.fastfood.adapters.controllers.ProdutoController produtoController = new com.fiaptech2024.fastfood.adapters.controllers.ProdutoController(this.produtoRepositoryInterface);
        return new ResponseEntity<>(produtoController.findByTipoProduto(tipoProduto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        com.fiaptech2024.fastfood.adapters.controllers.ProdutoController produtoController = new com.fiaptech2024.fastfood.adapters.controllers.ProdutoController(this.produtoRepositoryInterface);
        produtoController.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") UUID id, @RequestBody ProdutoUpdateRequest request) {
        com.fiaptech2024.fastfood.adapters.controllers.ProdutoController produtoController = new com.fiaptech2024.fastfood.adapters.controllers.ProdutoController(this.produtoRepositoryInterface);
        produtoController.atualizar(id, request.nome(), request.preco(), request.tipoProduto());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

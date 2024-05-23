package com.fiaptech2024.fastfood.adapter.driver.controllers.produto;

import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoServicePort;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import com.fiaptech2024.fastfood.core.services.produto.dtos.ProdutoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody ProdutoDTO produtoDTO){
        var produtoResponse = produtoServicePort.save(produtoDTO);
        return new ResponseEntity<>(produtoResponse, HttpStatus.CREATED);
    }

    @GetMapping("/tipo/{tipoProduto}")
    public ResponseEntity<List<Produto>> searchProdutoByTipoProduto(@PathVariable("tipoProduto") TipoProduto tipoProduto) {
        List<Produto> produtoResponse = produtoServicePort.findByTipoProduto(tipoProduto);
        return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        produtoServicePort.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") UUID id, @RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.update(id, produtoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

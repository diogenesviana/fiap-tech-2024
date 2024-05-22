package com.fiaptech2024.fastfood.adapter.driver.controllers.produto;

import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoServicePort;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        var produtoResponse = produtoServicePort.save(produto);
        return new ResponseEntity<>(produtoResponse, HttpStatus.CREATED);
    }

    @GetMapping("/tipo/{tipoProduto}")
    public ResponseEntity<List<Produto>> searchProdutoByTipoProduto(@PathVariable("tipoProduto") TipoProduto tipoProduto) {
        List<Produto> produtoResponse = produtoServicePort.findByTipoProduto(tipoProduto);
        return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
    }
}
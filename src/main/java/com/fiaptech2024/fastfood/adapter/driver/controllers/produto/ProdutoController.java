package com.fiaptech2024.fastfood.adapter.driver.controllers.produto;

import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.GetProduto.GetProduto;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.GetProduto.GetProdutoInput;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.GetProduto.GetProdutoOutput;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.SalvarProduto.SalvarProduto;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.SalvarProduto.SalvarProdutoInput;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.SalvarProduto.SalvarProdutoOutput;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.atualizarProduto.AtualizarProduto;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.atualizarProduto.AtualizarProdutoInput;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.deletarProduto.DeletarProduto;
import com.fiaptech2024.fastfood.core.applications.produto.usecases.deletarProduto.DeletarProdutoInput;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;
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

    private final ProdutoRepositoryInterface produtoRepositoryInterface;

    @PostMapping
    public ResponseEntity<SalvarProdutoOutput> create(@RequestBody SalvarProdutoInput input){
        SalvarProduto salvarProduto = new SalvarProduto(this.produtoRepositoryInterface);
        SalvarProdutoOutput output = salvarProduto.execute(input);
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @GetMapping("/tipo/{tipoProduto}")
    public ResponseEntity<List<GetProdutoOutput>> findByTipoProduto(@PathVariable("tipoProduto") TipoProduto tipoProduto) {
        GetProduto getProduto = new GetProduto(this.produtoRepositoryInterface);
        List<GetProdutoOutput> output = getProduto.execute(new GetProdutoInput(tipoProduto));
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        DeletarProduto deletarProduto = new DeletarProduto(this.produtoRepositoryInterface);
        deletarProduto.execute(new DeletarProdutoInput(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") UUID id, @RequestBody AtualizarProdutoInput input) {
        AtualizarProduto atualizarProduto = new AtualizarProduto(this.produtoRepositoryInterface);
        atualizarProduto.execute(id, input);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.fiaptech2024.fastfood.core.applications.produto.usecases.GetProduto;

import com.fiaptech2024.fastfood.core.applications.exception.EntityNotFoundException;
import com.fiaptech2024.fastfood.core.applications.produto.repositories.ProdutoRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class GetProduto {

    private final ProdutoRepositoryInterface produtoRepository;

    public GetProduto(ProdutoRepositoryInterface produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<GetProdutoOutput> execute(GetProdutoInput input) {
        List<Produto> produtos = this.produtoRepository.getProdutoByTipoProduto(input.tipoProduto());
        List<GetProdutoOutput> output = new ArrayList<>();
        if (produtos.isEmpty()) {
            throw new EntityNotFoundException("Produto não encontrado");
        }

        for(Produto produto : produtos){
            output.add(new GetProdutoOutput(
                    produto.getId(),
                    produto.getNome(),
                    produto.getPreco(),
                    produto.getTipoProduto()
            ));
        }
        return output;
    }
}

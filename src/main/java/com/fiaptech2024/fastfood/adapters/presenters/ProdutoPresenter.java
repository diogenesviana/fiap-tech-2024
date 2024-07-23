package com.fiaptech2024.fastfood.adapters.presenters;

import com.fiaptech2024.fastfood.core.domain.produto.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoPresenter {

    public static Object toObject(Produto produto) {
        Map<String, Object> presenter = new HashMap<>();
        presenter.put("id", produto.getId());
        presenter.put("nome", produto.getNome());
        presenter.put("preco", produto.getPreco());
        presenter.put("tipo_produto", produto.getTipoProduto());
        return presenter;
    }

    public static List<Object> toList(List<Produto> produtos) {
        List<Object> presenters = new ArrayList<>();
        for (Produto produto : produtos) {
            presenters.add(ProdutoPresenter.toObject(produto));
        }
        return presenters;
    }

}

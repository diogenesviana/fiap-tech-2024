package com.fiaptech2024.fastfood.adapters.presenters;

import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClientePresenter {

    public static Object toObject(Cliente cliente) {
        Map<String, Object> presenter = new HashMap<>();
        presenter.put("id", cliente.getId());
        presenter.put("nome", cliente.getNome());
        presenter.put("cpf", cliente.getCpf());
        presenter.put("data_criacao", cliente.getDataCriacao());
        presenter.put("email", cliente.getEmail());
        return presenter;
    }

}

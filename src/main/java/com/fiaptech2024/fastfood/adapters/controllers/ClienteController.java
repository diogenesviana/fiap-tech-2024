package com.fiaptech2024.fastfood.adapters.controllers;

import com.fiaptech2024.fastfood.adapters.presenters.ClientePresenter;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetClienteByCpf;
import com.fiaptech2024.fastfood.core.applications.cliente.usecases.SalvarCliente;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

import java.util.UUID;

public class ClienteController {

    private final ClienteRepositoryInterface clienteRepository;

    public ClienteController(ClienteRepositoryInterface clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Object get(UUID id) {
        GetCliente getCliente = new GetCliente(this.clienteRepository);
        Cliente cliente = getCliente.execute(id);
        return ClientePresenter.toObject(cliente);
    }

    public Object getByCpf(String cpf) {
        GetClienteByCpf getClienteByCpf = new GetClienteByCpf(this.clienteRepository);
        Cliente cliente = getClienteByCpf.execute(cpf);
        return ClientePresenter.toObject(cliente);
    }

    public Object salvar(String nome, String cpf, String email) {
        SalvarCliente salvarCliente = new SalvarCliente(this.clienteRepository);
        Cliente cliente = salvarCliente.execute(nome, cpf, email);
        return ClientePresenter.toObject(cliente);
    }

}

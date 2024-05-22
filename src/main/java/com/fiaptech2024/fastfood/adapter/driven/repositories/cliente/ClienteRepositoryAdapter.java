package com.fiaptech2024.fastfood.adapter.driven.repositories.cliente;

import com.fiaptech2024.fastfood.adapter.driven.entities.cliente.ClienteEntity;
import com.fiaptech2024.fastfood.core.applications.ports.cliente.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;

import lombok.AllArgsConstructor;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    @Override
    public Cliente getClienteById(UUID id){

        ClienteEntity entity = modelMapper.map(clienteRepository.findById(id), ClienteEntity.class);

        return modelMapper.map(entity, Cliente.class);

    }

    @Override
    public Cliente getClienteByCpf(String cpf){

        ClienteEntity entity = modelMapper.map(clienteRepository.findByCpf(cpf), ClienteEntity.class);

        return modelMapper.map(entity, Cliente.class);

    }    

    @Override
    public Boolean existsClienteByCpf(String cpf) {

        return clienteRepository.existsByCpf(cpf);

    }    

    @Override
    public Cliente saveCliente(Cliente cliente) {

        ClienteEntity entity = modelMapper.map(cliente, ClienteEntity.class);

        ClienteEntity save = clienteRepository.save(entity);

        return modelMapper.map(save, Cliente.class);

    }

}
package com.fiaptech2024.fastfood.adapter.driver.repositories;

import com.fiaptech2024.fastfood.adapter.driver.entities.ClienteEntity;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteRepository clienteRepository;

    private final ModelMapper modelMapper;

    @Override
    public Cliente saveCliente(Cliente cliente) {

        ClienteEntity entity = modelMapper.map(cliente, ClienteEntity.class);

        ClienteEntity save = clienteRepository.save(entity);

        return modelMapper.map(save, Cliente.class);

    }

}
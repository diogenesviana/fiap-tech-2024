package com.fiaptech2024.fastfood.adapters.gateways;

import com.fiaptech2024.fastfood.application.driven.entities.cliente.ClienteEntity;
import com.fiaptech2024.fastfood.application.driven.repositories.cliente.ClienteRepository;
import com.fiaptech2024.fastfood.core.applications.cliente.repositories.ClienteRepositoryInterface;
import com.fiaptech2024.fastfood.core.domain.cliente.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ClienteGateway implements ClienteRepositoryInterface {

    private final ClienteRepository clienteRepository;
    private final ModelMapper modelMapper;

    @Override
    public Cliente getClienteById(UUID id) {
        ClienteEntity entity = modelMapper.map(clienteRepository.findById(id), ClienteEntity.class);
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, Cliente.class);
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {
        ClienteEntity entity = modelMapper.map(clienteRepository.findByCpf(cpf), ClienteEntity.class);
        return modelMapper.map(entity, Cliente.class);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        ClienteEntity entity = modelMapper.map(cliente, ClienteEntity.class);
        ClienteEntity save = clienteRepository.save(entity);
        return modelMapper.map(save, Cliente.class);
    }
}

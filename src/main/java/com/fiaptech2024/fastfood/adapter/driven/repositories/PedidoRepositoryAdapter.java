package com.fiaptech2024.fastfood.adapter.driven.repositories;

import com.fiaptech2024.fastfood.adapter.driven.entities.ClienteEntity;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.Cliente;
import com.fiaptech2024.fastfood.core.domain.Pedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

//    private final ClienteRepository clienteRepository;

//    private final ModelMapper modelMapper;

    @Override
    public Pedido save(Pedido pedido) {
        return pedido;
    }

//    public Cliente getClienteById(UUID id){
//
//        ClienteEntity entity = modelMapper.map(clienteRepository.findById(id), ClienteEntity.class);
//
//        return modelMapper.map(entity, Cliente.class);
//
//    }
//
//    public Cliente getClienteByCpf(String cpf){
//
//        ClienteEntity entity = modelMapper.map(clienteRepository.findByCpf(cpf), ClienteEntity.class);
//
//        return modelMapper.map(entity, Cliente.class);
//
//    }
//
//    public Boolean existsClienteByCpf(String cpf) {
//
//        return clienteRepository.existsByCpf(cpf);
//
//    }
//
//    public Cliente saveCliente(Cliente cliente) {
//
//        ClienteEntity entity = modelMapper.map(cliente, ClienteEntity.class);
//
//        ClienteEntity save = clienteRepository.save(entity);
//
//        return modelMapper.map(save, Cliente.class);
//
//    }

}
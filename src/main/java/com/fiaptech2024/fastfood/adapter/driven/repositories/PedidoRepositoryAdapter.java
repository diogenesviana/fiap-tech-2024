package com.fiaptech2024.fastfood.adapter.driven.repositories;

import com.fiaptech2024.fastfood.adapter.driven.entities.PedidoEntity;
import com.fiaptech2024.fastfood.adapter.driven.entities.PedidoItemEntity;
import com.fiaptech2024.fastfood.core.applications.ports.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.domain.Pedido;
import com.fiaptech2024.fastfood.core.domain.PedidoItem;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    //    private final ClienteRepository clienteRepository;
    private PedidoRepository pedidoRepository;

    private final ModelMapper modelMapper;

    @Override
    public Pedido save(Pedido pedido) {
        ArrayList<PedidoItemEntity> itens = new ArrayList<>();
        for (PedidoItem pedidoItem: pedido.getItems()) {
//            itens.add(new PedidoItemEntity(pedidoItem));
        }
        return pedido;
        /*for (PedidoItem pedidoItem : this.items) {
            valor.add(pedidoItem.getValorItem());
        }*/
//        PedidoEntity pedidoEntity = new PedidoEntity(pedido.getId(),pedido.getValor(),pedido.get)
//        ClienteEntity entity = modelMapper.map(cliente, ClienteEntity.class);
//
//        ClienteEntity save = clienteRepository.save(entity);
//
//        return modelMapper.map(save, Cliente.class);
//        PedidoEntity entity = modelMapper.map(pedido, PedidoEntity.class);
//        return this.modelMapper.map(this.pedidoRepository.save(entity), Pedido.class);


//        return pedido;
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
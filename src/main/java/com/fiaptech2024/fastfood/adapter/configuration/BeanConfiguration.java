package com.fiaptech2024.fastfood.adapter.configuration;

import com.fiaptech2024.fastfood.core.applications.ports.cliente.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.cliente.ClienteServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.pedido.PedidoServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.produto.ProdutoServicePort;
import com.fiaptech2024.fastfood.core.services.cliente.ClienteService;
import com.fiaptech2024.fastfood.core.services.produto.ProdutoService;
import com.fiaptech2024.fastfood.core.services.pedido.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ClienteServicePort clienteServiceImpl(ClienteRepositoryPort clienteRepositoryPort) {
        return new ClienteService(clienteRepositoryPort);
    }

    @Bean
    public ProdutoServicePort produtoServiceImpl(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoService(produtoRepositoryPort);
    }

    @Bean
    public PedidoServicePort pedidoServiceImpl(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort) {
        return new PedidoService(pedidoRepositoryPort, produtoRepositoryPort);
    }

}
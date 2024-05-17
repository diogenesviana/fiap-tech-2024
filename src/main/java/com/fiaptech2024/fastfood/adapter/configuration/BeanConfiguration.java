package com.fiaptech2024.fastfood.adapter.configuration;

import com.fiaptech2024.fastfood.adapter.driven.repositories.PedidoRepositoryAdapter;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.ProdutoRepositoryPort;
import com.fiaptech2024.fastfood.core.applications.ports.ProdutoServicePort;
import com.fiaptech2024.fastfood.core.services.ClienteService;
import com.fiaptech2024.fastfood.core.services.ProdutoService;
import com.fiaptech2024.fastfood.core.applications.ports.PedidoServicePort;
import com.fiaptech2024.fastfood.core.services.PedidoService;
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
    public PedidoServicePort pedidoServiceImpl() {
        return new PedidoService(new PedidoRepositoryAdapter());
    }

}
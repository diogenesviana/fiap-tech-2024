package com.fiaptech2024.fastfood.adapter.driven.infra;

import com.fiaptech2024.fastfood.core.applications.ports.ClienteServicePort;
import com.fiaptech2024.fastfood.core.applications.ports.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.core.services.ClienteService;
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
    public ClienteServicePort clienteServiceImpl(ClienteRepositoryPort ClienteRepositoryPort) {
        return new ClienteService(ClienteRepositoryPort);
    }

}
package com.fiaptech2024.fastfood.infra;

import com.fiaptech2024.fastfood.domain.ports.ClienteServicePort;
import com.fiaptech2024.fastfood.domain.ports.ClienteRepositoryPort;
import com.fiaptech2024.fastfood.domain.services.ClienteService;
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
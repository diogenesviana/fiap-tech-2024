package com.fiaptech2024.fastfood.application.driven.repositories.cliente;


import com.fiaptech2024.fastfood.application.driven.entities.cliente.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity,UUID> {

    ClienteEntity findByCpf(String cpf);

    Boolean existsByCpf(String cpf);

}
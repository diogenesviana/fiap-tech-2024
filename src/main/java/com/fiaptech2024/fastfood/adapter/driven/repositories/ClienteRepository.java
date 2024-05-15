package com.fiaptech2024.fastfood.adapter.driven.repositories;


import com.fiaptech2024.fastfood.adapter.driven.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity,UUID> {

    ClienteEntity findByCpf(String cpf);

    Boolean existsByCpf(String cpf);

}
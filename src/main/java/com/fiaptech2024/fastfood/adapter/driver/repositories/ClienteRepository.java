package com.fiaptech2024.fastfood.adapter.driver.repositories;


import com.fiaptech2024.fastfood.adapter.driver.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity,UUID> {
}
package com.fiaptech2024.fastfood.adapter.repository;

import com.fiaptech2024.fastfood.adapter.entities.ClienteEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity,UUID> {
}
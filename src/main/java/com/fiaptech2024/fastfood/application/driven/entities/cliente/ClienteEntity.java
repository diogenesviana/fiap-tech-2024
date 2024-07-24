package com.fiaptech2024.fastfood.application.driven.entities.cliente;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CLIENTE")
public class ClienteEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    private String cpf;

    private String email;

    @CreationTimestamp
    private Instant dataCriacao;

}
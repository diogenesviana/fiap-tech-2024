package com.fiaptech2024.fastfood.core.applications.cliente.usecases.SalvarCliente;

import java.time.Instant;
import java.util.UUID;

public record SalvarClienteOutput(UUID id, String nome, String cpf, String email, Instant dataCriacao) {
}

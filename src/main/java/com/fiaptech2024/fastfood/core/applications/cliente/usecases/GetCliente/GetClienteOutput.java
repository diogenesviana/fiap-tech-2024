package com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetCliente;

import java.time.Instant;
import java.util.UUID;

public record GetClienteOutput(UUID id, String nome, String cpf, String email, Instant dataCriacao) {
}

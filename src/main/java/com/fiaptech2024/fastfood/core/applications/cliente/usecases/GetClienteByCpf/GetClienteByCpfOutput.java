package com.fiaptech2024.fastfood.core.applications.cliente.usecases.GetClienteByCpf;

import java.time.Instant;
import java.util.UUID;

public record GetClienteByCpfOutput(UUID id, String nome, String cpf, String email, Instant dataCriacao) {
}

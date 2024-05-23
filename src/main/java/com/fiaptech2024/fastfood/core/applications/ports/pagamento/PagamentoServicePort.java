package com.fiaptech2024.fastfood.core.applications.ports.pagamento;

import java.util.UUID;

public interface PagamentoServicePort {

    public void solicitarPagamento(UUID id);

}

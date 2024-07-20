package com.fiaptech2024.fastfood.core.domain.produto;

import com.fiaptech2024.fastfood.core.applications.exception.RegraDeNegocioException;
import com.fiaptech2024.fastfood.core.domain.produto.enums.TipoProduto;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private UUID id;

    private String nome;

    private BigDecimal preco;


    private TipoProduto tipoProduto;


    public Produto(){
    }

    public Produto(UUID id, String nome, BigDecimal preco, TipoProduto tipoProduto){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tipoProduto = tipoProduto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isBlank()){
            throw new RegraDeNegocioException("Nome não pode ser nulo");
        }
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new RegraDeNegocioException("Preço não pode ser nulo ou negativo");
        }
        this.preco = preco;
    }


    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        if(tipoProduto == null){
            throw new RegraDeNegocioException("Tipo de produto não pode ser nulo");
        }
        this.tipoProduto = tipoProduto;
    }
}

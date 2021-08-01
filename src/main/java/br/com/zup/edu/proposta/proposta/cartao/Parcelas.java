package br.com.zup.edu.proposta.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parcelas {
    @Id
    private String id;
    private Integer quantidade;
    private Double valor;

    public Parcelas() {
    }

    public Parcelas(String id, Integer quantidade, Double valor) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValor() {
        return valor;
    }
}

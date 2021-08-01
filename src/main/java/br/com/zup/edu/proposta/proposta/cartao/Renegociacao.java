package br.com.zup.edu.proposta.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Renegociacao {
    @Id
    private String id;
    private Integer quantidade;
    private Double valor;
    private LocalDateTime dataDeCriacao;

    public Renegociacao() {
    }

    public Renegociacao(String id, Integer quantidade, Double valor, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataDeCriacao = dataDeCriacao;
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

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}

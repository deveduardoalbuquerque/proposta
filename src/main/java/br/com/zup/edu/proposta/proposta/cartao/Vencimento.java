package br.com.zup.edu.proposta.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Vencimento {
    @Id
    private String id;
    private Double dia; // 1 - 31
    private LocalDateTime dataDeCriacao;

    public Vencimento() {
    }

    public Vencimento(String id, Double dia, LocalDateTime dataDeCriacao) {
        this.id = id;
        this.dia = dia;
        this.dataDeCriacao = dataDeCriacao;
    }

    public String getId() {
        return id;
    }

    public Double getDia() {
        return dia;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}

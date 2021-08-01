package br.com.zup.edu.proposta.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Avisos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate validoAte;
    private String destino;

    public Avisos() {
    }

    public Avisos(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }
}

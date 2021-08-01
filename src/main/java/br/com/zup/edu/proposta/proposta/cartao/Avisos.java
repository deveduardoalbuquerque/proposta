package br.com.zup.edu.proposta.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Avisos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate validoAte; //data de término
    private String destino; //destino da viagem
    private String aviso;
    private LocalDateTime instante = LocalDateTime.now();
    private String ipCliente;
    private String userAgent; //firefox, edge e etc

    //deprecated - usado apenas pelo hibernate
    public Avisos() {
    }

    public Avisos(LocalDate validoAte, String destino,
                  String ipCliente, String userAgent,
                  String aviso) {
        this.validoAte = validoAte;
        this.destino = destino;
        this.ipCliente = ipCliente;
        this.userAgent = userAgent;
        this.aviso = aviso;
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

    public LocalDateTime getInstante() {
        return instante;
    }

    public String getIpCliente() {
        return ipCliente;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getAviso() {
        return aviso;
    }
}

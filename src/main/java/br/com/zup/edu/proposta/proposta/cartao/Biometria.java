package br.com.zup.edu.proposta.proposta.cartao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Biometria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fingerprint;

    public Biometria() {
    }

    @JsonCreator
    public Biometria(@JsonProperty(value = "fingerprint") String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public Long getId() {
        return id;
    }

    public String getFingerprint() {
        return fingerprint;
    }
}

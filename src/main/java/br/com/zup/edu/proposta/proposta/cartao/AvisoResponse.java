package br.com.zup.edu.proposta.proposta.cartao;

import java.time.LocalDate;

public class AvisoResponse {
    private LocalDate validoAte;
    private String destino;

    public AvisoResponse(LocalDate validoAte, String destino) {
        this.validoAte = validoAte;
        this.destino = destino;
    }

    public LocalDate getValidoAte() {
        return validoAte;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "AvisoResponse{" +
                "validoAte=" + validoAte +
                ", destino='" + destino + '\'' +
                '}';
    }
}

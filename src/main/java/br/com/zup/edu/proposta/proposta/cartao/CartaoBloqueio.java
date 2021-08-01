package br.com.zup.edu.proposta.proposta.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class CartaoBloqueio {
    @Id
    private String id; //numero do cartao
    private LocalDateTime Createat = LocalDateTime.now(); //grava o momento do bloqueio
    @NotBlank
    private String ipcliente;
    @NotBlank
    private String agent;
    private String resultado;
    /*
        id": "string",
      "bloqueadoEm": "2021-07-31T18:26:54.901Z",
      "sistemaResponsavel": "string",
      "ativo": true
     */

    public CartaoBloqueio() {
    }

    public CartaoBloqueio(String id,String ipcliente, String agent, String resultado) {
        this.id = id;
        this.ipcliente = ipcliente;
        this.agent = agent;
        this.resultado = resultado;
    }


    public String getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreateat() {
        return Createat;
    }

    public String getIpcliente() {
        return ipcliente;
    }

    public String getAgent() {
        return agent;
    }
}

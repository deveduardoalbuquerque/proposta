package br.com.zup.edu.proposta.util;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SolicitacaoRequest {
    @NotNull
    private Long idProposta;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String documento;

    public SolicitacaoRequest(Long idProposta, String nome, String documento) {
        this.idProposta = idProposta;
        this.nome = nome;
        this.documento = documento;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }
}

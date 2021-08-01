package br.com.zup.edu.proposta.util;

public class SolicitacaoResponse {
    private Long idProposta;
    private String nome;
    private String documento;
    private PropostaAnalise resultadoSolicitacao;

    public SolicitacaoResponse() {
    }

    public SolicitacaoResponse(Long idProposta, String nome, String documento, PropostaAnalise resultadoSolicitacao) {
        this.idProposta = idProposta;
        this.nome = nome;
        this.documento = documento;
        this.resultadoSolicitacao = resultadoSolicitacao;
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

    public PropostaAnalise getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    @Override
    public String toString() {
        return "SolicitacaoResponse{" +
                "idProposta=" + idProposta +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", resultadoSolicitacao=" + resultadoSolicitacao +
                '}';
    }
}

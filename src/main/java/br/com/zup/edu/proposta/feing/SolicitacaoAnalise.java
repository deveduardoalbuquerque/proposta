package br.com.zup.edu.proposta.feing;


public class SolicitacaoAnalise {
    private String documento; //cpf
    private String nome;      //nome
    private String idProposta; //identificador

    public SolicitacaoAnalise(String documento, String nome, String idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getIdProposta() {
        return idProposta;
    }
}

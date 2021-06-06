package br.com.zup.edu.proposta.proposta;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

public class EnderecoRequest {
    @NotBlank @CPF
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    @NotBlank
    private String localidade;
    private String uf;

    public EnderecoRequest(String cep, String logradouro, String complemento,
                           String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public Endereco toEndereco(){
        return new Endereco(cep,logradouro,complemento,bairro,localidade,uf);
    }

    @Override
    public String toString() {
        return "EnderecoRequest{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}

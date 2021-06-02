package br.com.zup.edu.proposta.proposta;

import java.math.BigDecimal;

public class PropostaRequest {
    private String documento;
    private String email;
    private String nome;
//    private Endereco endereco;
    private BigDecimal salario;

    public PropostaRequest(String documento, String email, String nome,
                           Endereco endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
//        this.endereco = endereco;
        this.salario = salario;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

//    public Endereco getEndereco() {
//        return endereco;
//    }

    public BigDecimal getSalario() {
        return salario;
    }
}

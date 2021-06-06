package br.com.zup.edu.proposta.proposta;

import br.com.zup.edu.proposta.proposta.validation.CPFouCNPJ;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @CPFouCNPJ
    private String documento;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String nome;
    @OneToOne
    private Endereco endereco;
    @Column(nullable = false)
    private BigDecimal salario;

    public Proposta() {
    }

    public Proposta(String documento, String email, String nome, Endereco endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() {
        return id;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "id=" + id +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", salario=" + salario +
                '}';
    }
}

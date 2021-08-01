package br.com.zup.edu.proposta.proposta.cartao;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Cartao {
    @Id
    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private Integer limite;
    private String idProposta;

    @OneToMany
    private List<Bloqueios> bloqueios;
    @OneToMany
    private List<Avisos> avisos;
    @OneToMany
    private List<Carteiras> carteiras;
    @OneToMany
    private List<Parcelas> parcelas;
    @OneToMany
    private List<Renegociacao> renegociacao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vencimento_id", referencedColumnName = "id")
    private Vencimento vencimento;


    @OneToMany
    private List<Biometria> biometrias = new ArrayList<>();

    public Cartao() {
    }

//    @JsonCreator
//    public Cartao(@JsonProperty(value = "numero") String numero) {
//        this.id = numero;
//    }

    public Cartao(String id, LocalDateTime emitidoEm, String titular, Integer limite,
                  String idProposta, List<Bloqueios> bloqueios, List<Avisos> avisos,
                  List<Carteiras> carteiras, List<Parcelas> parcelas, List<Renegociacao> renegociacao,
                  List<Biometria> biometrias, Vencimento vencimento) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.idProposta = idProposta;
        this.bloqueios = bloqueios;
        this.avisos = avisos;
        this.carteiras = carteiras;
        this.parcelas = parcelas;
        this.renegociacao = renegociacao;
        this.biometrias = biometrias;
        this.vencimento = vencimento;
    }

    public String getId() {
        return id;
    }

    public List<Biometria> getBiometrias() {
        return Collections.unmodifiableList(biometrias);
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public String getTitular() {
        return titular;
    }

    public Integer getLimite() {
        return limite;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public List<Bloqueios> getBloqueios() {
        return Collections.unmodifiableList(bloqueios);
    }

    public List<Avisos> getAvisos() {
        return Collections.unmodifiableList(avisos);
    }

    public List<Carteiras> getCarteiras() {
        return Collections.unmodifiableList(carteiras);
    }

    public List<Parcelas> getParcelas() {
        return Collections.unmodifiableList(parcelas);
    }

    public List<Renegociacao> getRenegociacao() {
        return Collections.unmodifiableList(renegociacao);
    }


    public Vencimento getVencimento() {
        return vencimento;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id='" + id + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", titular='" + titular + '\'' +
                ", limite=" + limite +
                ", idProposta='" + idProposta + '\'' +
                ", bloqueios=" + bloqueios +
                ", avisos=" + avisos +
                ", carteiras=" + carteiras +
                ", parcelas=" + parcelas +
                ", renegociacao=" + renegociacao +
                ", biometrias=" + biometrias +
                '}';
    }
}

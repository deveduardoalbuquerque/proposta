package br.com.zup.edu.proposta.feing;

import br.com.zup.edu.proposta.proposta.cartao.Cartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:8888", name = "recebecartao")
public interface RecebeCartao {

    @PostMapping(value = "/api/cartoes")
    public Cartao getIdCartao(SolicitacaoAnalise solicitacaoAnalise);

    @PostMapping(value = "/api/cartoes/{cartaoId}/bloqueios", consumes = "application/json", produces = "application/json")
    public String cartaoBloqueio(@PathVariable String cartaoId, String sistemaResponsavel);

}

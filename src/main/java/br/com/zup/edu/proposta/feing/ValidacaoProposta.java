package br.com.zup.edu.proposta.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:9999", name = "valida")
public interface ValidacaoProposta {

    @PostMapping("/api/solicitacao")
    ResultadoAnalise validaProposta(SolicitacaoAnalise solicitacaoAnalise);

}


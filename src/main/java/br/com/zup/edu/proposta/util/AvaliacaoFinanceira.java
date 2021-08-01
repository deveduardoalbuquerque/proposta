package br.com.zup.edu.proposta.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "http://localhost:9999/api/solicitacao" , name = "consultaFinanceiro")
public interface AvaliacaoFinanceira {

    @PostMapping
    SolicitacaoResponse consulta(SolicitacaoRequest request);
}

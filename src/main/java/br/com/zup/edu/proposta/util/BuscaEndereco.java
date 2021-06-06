package br.com.zup.edu.proposta.util;

import br.com.zup.edu.proposta.proposta.EnderecoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "https://viacep.com.br/ws",name = "teste")
public interface BuscaEndereco {

    @RequestMapping("/{cep}/json/")
    public EnderecoRequest carregaEndereceo(@PathVariable String cep);

}

package br.com.zup.edu.proposta.proposta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @PostMapping
    public PropostaRequest salvaProposta(@RequestBody PropostaRequest proposta){

        return proposta;

    }


}

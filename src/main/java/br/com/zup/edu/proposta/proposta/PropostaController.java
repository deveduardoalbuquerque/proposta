package br.com.zup.edu.proposta.proposta;

import br.com.zup.edu.proposta.util.BuscaEndereco;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    private PropostaRepository propostaRepository;
    private EnderecoRepository enderecoRepository;
    private BuscaEndereco buscaEndereco;

    public PropostaController(PropostaRepository propostaRepository,
                              EnderecoRepository enderecoRepository,
                              BuscaEndereco buscaEndereco) {
        this.propostaRepository = propostaRepository;
        this.enderecoRepository = enderecoRepository;
        this.buscaEndereco = buscaEndereco;
    }

    @PostMapping
    public void salvaProposta(@RequestBody @Valid PropostaRequest proposta){

        EnderecoRequest enderecoRequest = buscaEndereco.carregaEndereceo(proposta.getCep());
        if(enderecoRequest.getCep().isEmpty()){
            throw new RuntimeException("Endereço Enválido - Verifique CEP enviado");
        }



        //        return proposta.toProposta(enderecoRequest);
//        return repository.save(proposta.toProposta());

    }


}

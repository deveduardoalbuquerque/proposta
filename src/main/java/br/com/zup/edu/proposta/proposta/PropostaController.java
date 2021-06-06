package br.com.zup.edu.proposta.proposta;

import br.com.zup.edu.proposta.erroshandle.CEPNaoEncontrado;
import br.com.zup.edu.proposta.util.BuscaEndereco;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> salvaProposta(@RequestBody @Valid PropostaRequest proposta){

        EnderecoRequest enderecoRequest = buscaEndereco.carregaEndereceo(proposta.getCep());
        if(enderecoRequest.getCep() == null){
            throw new CEPNaoEncontrado("Endereço Enválido - Verifique CEP enviado");
        }

        Endereco enderecoSalvo = enderecoRepository.save(enderecoRequest.toEndereco());
        Proposta propostaSalva= propostaRepository.save(proposta.toProposta(enderecoSalvo));
        return ResponseEntity.ok(propostaSalva);

    }


}

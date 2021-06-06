package br.com.zup.edu.proposta.proposta;

import br.com.zup.edu.proposta.erroshandle.ApiErrorHandle;
import br.com.zup.edu.proposta.erroshandle.CEPNaoEncontrado;
import br.com.zup.edu.proposta.erroshandle.PropostaNaoEncontrada;
import br.com.zup.edu.proposta.util.BuscaEndereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

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
    public ResponseEntity<?> salvaProposta(@RequestBody @Valid PropostaRequest proposta,
                                           UriComponentsBuilder uriComponentsBuilder){

        EnderecoRequest enderecoRequest = buscaEndereco.carregaEndereceo(proposta.getCep());
        if(enderecoRequest.getCep() == null){
            throw new CEPNaoEncontrado("Endereço Enválido - Verifique CEP enviado");
        }

        Endereco enderecoSalvo = enderecoRepository.save(enderecoRequest.toEndereco());
        Proposta propostaSalva= propostaRepository.save(proposta.toProposta(enderecoSalvo));

        URI uri = uriComponentsBuilder.path("/propostas/{propostaId}")
                .buildAndExpand(propostaSalva.getId())
                .toUri();

        return ResponseEntity.created(uri).build();

    }

    @GetMapping("/{propostaId}")
    public ResponseEntity<Proposta> pegaProposta(@PathVariable Long propostaId){
        Optional<Proposta> temProposta = propostaRepository.findById(propostaId);

        if(temProposta.isEmpty()) throw new PropostaNaoEncontrada("Proposta de número " +propostaId+ " Não Encontrada");

        return ResponseEntity.ok(temProposta.get());


    }


}

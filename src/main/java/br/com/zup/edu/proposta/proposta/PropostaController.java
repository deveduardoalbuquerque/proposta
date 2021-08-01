package br.com.zup.edu.proposta.proposta;

import br.com.zup.edu.proposta.erroshandle.PropostaNaoEncontrada;
import br.com.zup.edu.proposta.feing.*;
import br.com.zup.edu.proposta.proposta.cartao.Cartao;
import br.com.zup.edu.proposta.proposta.cartao.CartaoRepository;
import br.com.zup.edu.proposta.util.AvaliacaoFinanceira;
import br.com.zup.edu.proposta.util.BuscaEndereco;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/propostas")
public class PropostaController {

    private PropostaRepository propostaRepository;
    private EnderecoRepository enderecoRepository;
    private BuscaEndereco buscaEndereco;
    private AvaliacaoFinanceira avaliacaoFinanceira;
    private ValidacaoProposta validacaoProposta;
    private RecebeCartao recebeCartao;
    private CartaoRepository cartaoRepository;

    public PropostaController(PropostaRepository propostaRepository,
                              EnderecoRepository enderecoRepository,
                              BuscaEndereco buscaEndereco,
                              AvaliacaoFinanceira avaliacaoFinanceira,
                              ValidacaoProposta validacaoProposta,
                              RecebeCartao recebeCartao,
                              CartaoRepository cartaoRepository) {
        this.propostaRepository = propostaRepository;
        this.enderecoRepository = enderecoRepository;
        this.buscaEndereco = buscaEndereco;
        this.avaliacaoFinanceira = avaliacaoFinanceira;
        this.validacaoProposta = validacaoProposta;
        this.recebeCartao = recebeCartao;
        this.cartaoRepository = cartaoRepository;
    }

    @PostMapping
    @Transactional
    public ResultadoAnalise salvaProposta(@RequestBody @Valid PropostaRequest proposta){

        Endereco endereco = new Endereco(
                "59067610",
                "rua qualquer coisa",
                "Complemento qualquer coisa",
                "Bairro qualquer coisa",
                "localidade Qualquer coisa",
                "RN"
        );

        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        Proposta propostaSalva = propostaRepository.save(proposta.toProposta(enderecoSalvo));


        //para poder consumir o endpoint de analise
        SolicitacaoAnalise solicitacao =
                new SolicitacaoAnalise(
                        propostaSalva.getDocumento(),
                        propostaSalva.getNome(),
                        propostaSalva.getId().toString());

        //validacao pelo feing
        ResultadoAnalise resultadoAnalise = validacaoProposta.validaProposta(solicitacao);

        //SE O RESULTADO FOR SEM_RESTRINCAO DEVO SOLICITAR UM CARTAO
        ResultadoSolicitacao resultado = resultadoAnalise.getResultadoSolicitacao();

        if(resultado == ResultadoSolicitacao.SEM_RESTRICAO){
            String idProposta = propostaSalva.getId().toString(); //pego para uma variavel o IDPROPOSTA
//            Cartao numeroCartao = recebeCartao.getIdCartao(solicitacao); //estou passando o IDPOROPOSTA PARA FEIGN
            Cartao numeroCartao = recebeCartao.getIdCartao(solicitacao);
            System.out.println("*************************" + numeroCartao);
            //salva o cartão de na entidade
            Cartao cartaoSalvo = cartaoRepository.save(numeroCartao);
            //vinculo do cartao na proposta
            propostaSalva.setCartao(cartaoSalvo);
        }

        return resultadoAnalise;

    }

    @GetMapping("/{propostaId}") // 1
    public ResponseEntity<Proposta> pegaProposta(@PathVariable Long propostaId){
        Optional<Proposta> temProposta = propostaRepository.findById(propostaId);

        if(temProposta.isEmpty()) throw new PropostaNaoEncontrada(
                "Proposta de número " +propostaId+ " Não Encontrada");

        return ResponseEntity.ok(temProposta.get());


    }


}

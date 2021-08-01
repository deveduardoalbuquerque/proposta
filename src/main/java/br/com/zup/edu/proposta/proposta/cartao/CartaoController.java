package br.com.zup.edu.proposta.proposta.cartao;

import br.com.zup.edu.proposta.feing.RecebeCartao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cartoes")
public class CartaoController {

    private CartaoRepository cartaoRepository;
    private BloqueiosRepository bloqueioRepository;
    private RecebeCartao recebeCartao;

    public CartaoController(CartaoRepository cartaoRepository,
                            BloqueiosRepository bloqueioRepository,
                            RecebeCartao recebeCartao) {
        this.cartaoRepository = cartaoRepository;
        this.bloqueioRepository = bloqueioRepository;
        this.recebeCartao = recebeCartao;
    }

    @PostMapping("/{cartaoId}")
    public ResponseEntity<?> bloqueiaCartao(@RequestBody String sistemaResponsavel,
                                            @PathVariable String cartaoId,
                                            HttpServletRequest request){

        if(sistemaResponsavel.isBlank() || cartaoId.isBlank()){
            return ResponseEntity.badRequest().build(); //400
        }

        Optional<Cartao> temCartao = cartaoRepository.findById(cartaoId);

        if(temCartao.isPresent()){
            if(temCartao.get().getBloqueios().isEmpty()){
                return ResponseEntity.unprocessableEntity().build(); //422
            }

            String bloqueio = recebeCartao.cartaoBloqueio(cartaoId,sistemaResponsavel);//feign
            Bloqueios cartaoBloqueio = new Bloqueios(
                    cartaoId,LocalDateTime.now(),sistemaResponsavel,true);
            //persisto no banco
            Bloqueios bloqueios = bloqueioRepository.save(cartaoBloqueio);
            return ResponseEntity.ok(bloqueios); //200
        }
        return ResponseEntity.notFound().build(); //404
    }
}


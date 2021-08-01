package br.com.zup.edu.proposta.proposta.cartao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/biometrias")
public class BiometriaController {

    private BiometriaRepository biometriaRepository;
    private CartaoRepository cartaoRepository;

    public BiometriaController(BiometriaRepository biometriaRepository, CartaoRepository cartaoRepository) {
        this.biometriaRepository = biometriaRepository;
        this.cartaoRepository = cartaoRepository;
    }

    @PostMapping("/{cartaoId}")
    public ResponseEntity<?> salvaBiometria(@PathVariable String cartaoId){

        Optional<Cartao> temCartao = cartaoRepository.findById(cartaoId);
        if(temCartao.isPresent()){

            Long numeroAleatorio = new Random().nextLong();
            byte[] finger = numeroAleatorio.toString().getBytes();
            String fingerprint = Base64.getEncoder().encodeToString(finger);

            biometriaRepository.save(new Biometria(fingerprint));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Biometria> listaTudo(){
        return biometriaRepository.findAll();
    }

}

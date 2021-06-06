package br.com.zup.edu.proposta.erroshandle;

public class CEPNaoEncontrado extends RuntimeException {
    public CEPNaoEncontrado(String message) {
        super(message);
    }
}

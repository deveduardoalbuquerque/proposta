package br.com.zup.edu.proposta.erroshandle;

public class PropostaNaoEncontrada extends RuntimeException {
    public PropostaNaoEncontrada(String message) {
        super(message);
    }
}

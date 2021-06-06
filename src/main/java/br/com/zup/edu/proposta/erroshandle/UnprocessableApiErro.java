package br.com.zup.edu.proposta.erroshandle;

public class UnprocessableApiErro extends RuntimeException{
    public UnprocessableApiErro(String message) {
        super(message);
    }
}

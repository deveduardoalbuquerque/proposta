package br.com.zup.edu.proposta.erroshandle;

public class ErrosResponse {
    private String message;
    private String campo;

    public ErrosResponse(String message, String campo) {
        this.message = message;
        this.campo = campo;
    }

    public String getMessage() {
        return message;
    }

    public String getCampo() {
        return campo;
    }
}

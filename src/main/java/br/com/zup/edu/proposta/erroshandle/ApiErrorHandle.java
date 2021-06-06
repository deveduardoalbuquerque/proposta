package br.com.zup.edu.proposta.erroshandle;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiErrorHandle {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrosResponse> errosDeValidacao(MethodArgumentNotValidException exception){

        //pego lista de erros que está vindo do controller
        List<FieldError> listaDeErros = exception.getBindingResult().getFieldErrors();

        //lista de Response para devolver para o cliente
        List<ErrosResponse> erros = new ArrayList<>();

        listaDeErros
                .stream()
                .map(x->erros
                        .add(new ErrosResponse(x.getDefaultMessage(),x.getField())))
                .collect(Collectors.toList());

        return erros;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CEPNaoEncontrado.class)
    public ErrosResponse CEPNaoEncontrado(CEPNaoEncontrado ex){
        ErrosResponse erros = new ErrosResponse(ex.getMessage(), "CEP");
        return  erros;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PropostaNaoEncontrada.class)
    public ErrosResponse propostaNaoEncontrada(PropostaNaoEncontrada ex){
        return new ErrosResponse(ex.getMessage(), "Id da Proposta");
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(UnprocessableApiErro.class)
    public ErrosResponse unprocessableApiErro(UnprocessableApiErro ex){
        return new ErrosResponse("Pedido não processado","Solicitação de proposta");

    }

}

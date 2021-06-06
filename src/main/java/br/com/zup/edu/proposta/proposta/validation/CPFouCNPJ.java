package br.com.zup.edu.proposta.proposta.validation;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFouCNPJ {
    String message() default "Documento Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

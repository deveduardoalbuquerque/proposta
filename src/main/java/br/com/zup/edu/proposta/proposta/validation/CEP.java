package br.com.zup.edu.proposta.proposta.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CEPValidator.class)
public @interface CEP {
    String message() default "Formado do CEP invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class CEPValidator implements ConstraintValidator<CEP,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("[0-9]{2}.[0-9]{3}-[0-9]{3}") || s.matches("[0-9]{5}-[0-9]{3}")|| s.matches("[0-9]{8}");
    }
}

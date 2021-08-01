package br.com.zup.edu.proposta.proposta.validation;

import br.com.zup.edu.proposta.erroshandle.UnprocessableApiErro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProibiDuplicadoNoBancoValidator.class)
public @interface ProibiDuplicadoNoBanco {
    String message() default "Valor Duplicado no Banco";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> aClass();
    String campo();
}

class ProibiDuplicadoNoBancoValidator implements ConstraintValidator<ProibiDuplicadoNoBanco,Object>{

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> aClass;
    private String campo;

    @Override
    public void initialize(ProibiDuplicadoNoBanco constraintAnnotation) {
        this.aClass = constraintAnnotation.aClass();
        this.campo = constraintAnnotation.campo();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT p FROM "+ aClass.getName() +" p WHERE p." + campo + "= :valor");
        System.out.println(o);
        query.setParameter("valor", o);
        List<Object> list = query.getResultList();
        if(list.isEmpty()) return true;

        throw new UnprocessableApiErro("Pedido nao pode ser processado");

    }


}

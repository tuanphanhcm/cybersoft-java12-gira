package cybersoft.javabackend.java12.gira.role.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java12.gira.role.validation.validator.ValidDescriptionValidator;

@Constraint(validatedBy = ValidDescriptionValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface ValidDescription {
	public String message() default "Description is not valid.";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

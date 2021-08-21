package cybersoft.javabackend.java12.gira.user.validation.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java12.gira.user.validation.validator.ConfirmPasswordValidator;

@Constraint(validatedBy = ConfirmPasswordValidator.class)
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfirmPassword {
	String message() default "Confirm password is not same with password.";

	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };
}

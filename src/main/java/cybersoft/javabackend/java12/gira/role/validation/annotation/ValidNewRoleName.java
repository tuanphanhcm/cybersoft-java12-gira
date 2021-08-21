package cybersoft.javabackend.java12.gira.role.validation.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java12.gira.role.validation.validator.ValidNewRoleNameValidator;

@Constraint(validatedBy = ValidNewRoleNameValidator.class)
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ValidNewRoleName {
	String message() default "Description is not valid.";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

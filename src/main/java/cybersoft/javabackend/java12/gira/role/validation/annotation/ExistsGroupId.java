package cybersoft.javabackend.java12.gira.role.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java12.gira.role.validation.validator.ExistsGroupIdValidator;

@Constraint(validatedBy = ExistsGroupIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface ExistsGroupId {
	public String message() default "Group doesn't exist.";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

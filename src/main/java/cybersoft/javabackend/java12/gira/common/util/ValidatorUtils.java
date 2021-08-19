package cybersoft.javabackend.java12.gira.common.util;

import javax.validation.ConstraintValidatorContext;

public class ValidatorUtils {
	public static void addError(ConstraintValidatorContext context,
			String message) {
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation()
		.disableDefaultConstraintViolation();
	}
}

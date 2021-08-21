package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExistsGroupId;

public class ExistsGroupIdValidator implements ConstraintValidator<ExistsGroupId, Long> {
	private String message;
	private GroupService service;
	
	public ExistsGroupIdValidator(GroupService groupService) {
		service = groupService;
	}

	@Override
	public void initialize(ExistsGroupId constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long groupId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExisted(groupId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}

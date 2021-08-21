package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;
import cybersoft.javabackend.java12.gira.role.validation.annotation.UniqueGroupName;

public class UniqueGroupNameValidator implements ConstraintValidator<UniqueGroupName, String> {
	private String message;
	private GroupService service;
	
	public UniqueGroupNameValidator(GroupService groupService) {
		service = groupService;
	}
	
	@Override
	public void initialize(UniqueGroupName constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String groupName, ConstraintValidatorContext context) {
		boolean isTaken = service.isTakenName(groupName);
		
		if(!isTaken)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}

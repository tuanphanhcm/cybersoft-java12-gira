package cybersoft.javabackend.java12.gira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java12.gira.common.util.ValidatorUtils;
import cybersoft.javabackend.java12.gira.role.dto.UpdateRoleDto;
import cybersoft.javabackend.java12.gira.role.service.itf.RoleService;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ValidNewRoleName;

public class ValidNewRoleNameValidator implements ConstraintValidator<ValidNewRoleName, UpdateRoleDto> {
	private String message;
	private RoleService service;
	
	public ValidNewRoleNameValidator(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public void initialize(ValidNewRoleName constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(UpdateRoleDto dto, ConstraintValidatorContext context) {
		if(dto.getName().equals(dto.getOldName())) {
			boolean isTaken = service.isTakenName(dto.getName());
			
			if(!isTaken)
				return true;
		}
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}

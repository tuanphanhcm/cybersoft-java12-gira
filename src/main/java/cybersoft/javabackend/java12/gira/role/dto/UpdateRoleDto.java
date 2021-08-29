package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.java12.gira.role.validation.annotation.ValidNewRoleName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ValidNewRoleName
public class UpdateRoleDto {
	@NotNull
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String oldName;
	
	private String description;
}

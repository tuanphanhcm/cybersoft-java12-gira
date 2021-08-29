package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java12.gira.role.validation.annotation.UniqueGroupName;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ValidDescription;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateGroupDto {
	@NotBlank(message = "{group.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	@UniqueGroupName(message = "{group.name.used}")
	private String name;
	
	@ValidDescription
	private String description;

}

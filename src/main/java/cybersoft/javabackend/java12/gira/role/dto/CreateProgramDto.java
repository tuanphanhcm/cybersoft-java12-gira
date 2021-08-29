package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java12.gira.role.util.HttpMethods;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProgramDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	private String name;
	
	@NotBlank
	private String path;
	
	@NotNull
	private HttpMethods method;
}

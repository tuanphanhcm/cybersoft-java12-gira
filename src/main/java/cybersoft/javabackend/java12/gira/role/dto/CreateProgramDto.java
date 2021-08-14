package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java12.gira.role.util.HttpMethods;

public class CreateProgramDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	private String name;
	
	@NotBlank
	private String path;
	
	@NotNull
	private HttpMethods method;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpMethods getMethod() {
		return method;
	}

	public void setMethod(HttpMethods method) {
		this.method = method;
	}
}

package cybersoft.javabackend.java12.gira.role.dto;

import java.util.Set;

import cybersoft.javabackend.java12.gira.role.entity.Program;
import cybersoft.javabackend.java12.gira.role.util.HttpMethods;

public interface ProgramDto {
	// projection
	public Long getId();
	public String getName();
	public HttpMethods getMethod();
	public String getPath();
	
}

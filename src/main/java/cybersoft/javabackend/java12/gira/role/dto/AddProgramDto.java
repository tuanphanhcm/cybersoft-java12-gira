package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.java12.gira.role.validation.annotation.ExistsProgramId;
import cybersoft.javabackend.java12.gira.role.validation.annotation.ExistsRoleId;

public class AddProgramDto {
	@NotNull
	@Min(value = 1)
	@ExistsRoleId
	private Long roleId;
	
	@NotNull
	@Min(value = 1)
	@ExistsProgramId
	private Long programId;
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}
}

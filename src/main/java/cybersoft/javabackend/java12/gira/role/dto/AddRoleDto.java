package cybersoft.javabackend.java12.gira.role.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddRoleDto {
	@NotNull
	@Min(value = 1)
	private Long groupId;
	
	@NotNull
	@Min(value = 1)
	private Long roleId;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}

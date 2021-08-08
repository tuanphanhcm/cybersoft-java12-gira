package cybersoft.javabackend.java12.gira.role.service.itf;

import java.util.List;

import cybersoft.javabackend.java12.gira.role.dto.CreateRoleDto;
import cybersoft.javabackend.java12.gira.role.entity.Role;
// abstraction
public interface RoleService {
	// contract
	List<Role> findAll();

	Role addNewRole(CreateRoleDto dto);
}

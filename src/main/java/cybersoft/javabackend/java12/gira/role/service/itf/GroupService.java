package cybersoft.javabackend.java12.gira.role.service.itf;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java12.gira.role.dto.AddRoleDto;
import cybersoft.javabackend.java12.gira.role.dto.AddUserDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateGroupDto;
import cybersoft.javabackend.java12.gira.role.dto.GroupDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;

public interface GroupService {

	boolean isTakenName(String groupName);

	List<GroupDto> findAll();

	Group add(CreateGroupDto dto);

	boolean isExisted(Long groupId);

	Group addRole(AddRoleDto dto);

	Group addUser(AddUserDto dto);

}

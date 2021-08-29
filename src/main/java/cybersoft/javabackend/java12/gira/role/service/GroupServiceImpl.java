package cybersoft.javabackend.java12.gira.role.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.java12.gira.role.dto.AddRoleDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateGroupDto;
import cybersoft.javabackend.java12.gira.role.dto.GroupDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.role.entity.Role;
import cybersoft.javabackend.java12.gira.role.repository.GroupRepository;
import cybersoft.javabackend.java12.gira.role.repository.RoleRepository;
import cybersoft.javabackend.java12.gira.role.service.itf.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
	private final GroupRepository repository;
	private final RoleRepository roleRepository;

	public GroupServiceImpl(GroupRepository groupRepository, RoleRepository roleRepository) {
		repository = groupRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public boolean isTakenName(String groupName) {
		return repository.countByName(groupName) >= 1;
	}

	@Override
	public List<GroupDto> findAll() {
		return repository.findAllDto();
	}

	@Override
	public Group add(CreateGroupDto dto) {
		Group group = new Group();
		group.setName(dto.getName());
		group.setDescription(dto.getDescription());
		
		return repository.save(group);
	}

	@Override
	public boolean isExisted(Long groupId) {
		return repository.existsById(groupId);
	}

	@Override
	public Group addRole(AddRoleDto dto) {
		Group group = repository.getById(dto.getGroupId());
		Role role = roleRepository.getById(dto.getRoleId());
		group.addRole(role);
		return repository.save(group);
	}

}

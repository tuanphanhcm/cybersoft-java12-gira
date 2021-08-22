package cybersoft.javabackend.java12.gira.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.javabackend.java12.gira.role.dto.AddProgramDto;
import cybersoft.javabackend.java12.gira.role.dto.CreateRoleDto;
import cybersoft.javabackend.java12.gira.role.dto.RoleDto;
import cybersoft.javabackend.java12.gira.role.dto.UpdateRoleDto;
import cybersoft.javabackend.java12.gira.role.entity.Program;
import cybersoft.javabackend.java12.gira.role.entity.Role;
import cybersoft.javabackend.java12.gira.role.repository.ProgramRepository;
import cybersoft.javabackend.java12.gira.role.repository.RoleRepository;
import cybersoft.javabackend.java12.gira.role.service.itf.RoleService;

// concrete
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	private RoleRepository repository;
	private ProgramRepository programRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository,
			ProgramRepository programRepository) {
		repository = roleRepository;
		this.programRepository = programRepository;
	}
	
	@Override
	public List<RoleDto> findAll() {
		return repository.findAllDto();
	}

	@Override
	public Role addNewRole(CreateRoleDto dto) {
		Role newRole = new Role();
		
		newRole.setName(dto.getName().toUpperCase());
		newRole.setDescription(dto.getDescription());
		
		return repository.save(newRole);
	}

	@Override
	public Role addProgram(AddProgramDto dto) {
		Role role = repository.getById(dto.getRoleId()); 
		Program program = programRepository.getById(dto.getProgramId());
		
		role.addProgram(program);
		
		return repository.save(role);
	}

	@Override
	public boolean isTakenName(String roleName) {
		return repository.countByName(roleName.toUpperCase()) >= 1;
	}

	@Override
	public boolean isExistedId(Long roleId) {
		return repository.existsById(roleId);
	}

	@Override
	public Role removeProgram(@Valid AddProgramDto dto) {
		Role role = repository.getById(dto.getRoleId()); 
		Program program = programRepository.getById(dto.getProgramId());
		
		role.removeProgram(program);
		
		return repository.save(role);
	}

	@Override
	public Role update(UpdateRoleDto dto, Long id) {
		Role role = repository.getById(id);
		
		role.setName(dto.getName().toUpperCase()); // add uppercase
		role.setDescription(dto.getDescription());
		
		return repository.save(role);
	}

	@Override
	public void deleteById(Long roleId) {
		repository.deleteById(roleId);;
	}

}

package cybersoft.javabackend.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.java12.gira.role.dto.CreateProgramDto;
import cybersoft.javabackend.java12.gira.role.dto.ProgramDto;
import cybersoft.javabackend.java12.gira.role.entity.Program;
import cybersoft.javabackend.java12.gira.role.repository.ProgramRepository;
import cybersoft.javabackend.java12.gira.role.service.itf.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {
	private ProgramRepository repository;
	
	public ProgramServiceImpl(ProgramRepository programRepository) {
		repository = programRepository;
	}
	
	@Override
	public List<ProgramDto> findAll() {
		return repository.findAllDto();
	}

	@Override
	public Program saveProgram(CreateProgramDto dto) {
		Program program = Program.builder()
				.name(dto.getName())
				.method(dto.getMethod())
				.path(dto.getPath())
				.build();
		
		return repository.save(program);
	}

	@Override
	public boolean isExistedId(Long programId) {
		return repository.existsById(programId);
	}
	
}

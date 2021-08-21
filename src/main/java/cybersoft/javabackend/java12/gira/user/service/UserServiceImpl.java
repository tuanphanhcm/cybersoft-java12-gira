package cybersoft.javabackend.java12.gira.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.java12.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.entity.User;
import cybersoft.javabackend.java12.gira.user.repository.UserRepository;
import cybersoft.javabackend.java12.gira.user.util.UserStatus;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	
	public UserServiceImpl(UserRepository userRepository) {
		repository = userRepository;
	}

	@Override
	public List<UserDto> findAllDto() {
		return repository.findAllUserDto();
	}

	@Override
	public boolean isTakenUsername(String username) {
		return repository.countByUsername(username.toLowerCase()) >= 1;
	}

	@Override
	public boolean isTakenEmail(String email) {
		return repository.countByEmail(email) >= 1;
	}

	@Override
	public User createUser(CreateUserDto dto) {
		User newUser = new User();
		
		newUser.setUsername(dto.getUsername());
		newUser.setEmail(dto.getEmail());
		newUser.setPassword(dto.getPassword()); // encode password  trước khi set
		newUser.setStatus(UserStatus.ACTIVE);
		
		return repository.save(newUser);
	}
}

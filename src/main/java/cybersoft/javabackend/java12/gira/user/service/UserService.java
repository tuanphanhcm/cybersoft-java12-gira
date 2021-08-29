package cybersoft.javabackend.java12.gira.user.service;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java12.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserProgramDto;
import cybersoft.javabackend.java12.gira.user.entity.User;

public interface UserService {

	List<UserDto> findAllDto();

	boolean isTakenUsername(String username);

	boolean isTakenEmail(String email);

	User createUser(CreateUserDto dto);

	List<UserProgramDto> findAllProgramsOfUser(String username);

}

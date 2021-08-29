package cybersoft.javabackend.java12.gira.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java12.gira.common.ResponseHandler;
import cybersoft.javabackend.java12.gira.user.dto.CreateUserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserProgramDto;
import cybersoft.javabackend.java12.gira.user.entity.User;
import cybersoft.javabackend.java12.gira.user.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	private UserService service;
	
	public UserController(UserService userService) {
		service = userService;
	}
	
	@GetMapping
	public Object findAllUser() {
		List<UserDto> users = service.findAllDto();
		
		return ResponseHandler.getResponse(users, HttpStatus.OK);
	}
	
	@GetMapping("/{username}/programs")
	public Object getAllProgramsOfUser(@PathVariable("username") String username ) {
		List<UserProgramDto> programs = service.findAllProgramsOfUser(username);
		/*
		 * 	path: /api/user/%/programs
		 *  thực tế: /api/user/admin/programs
		 */
		"/api/user/admin/programs".matches("/api/user/%/programs");
		
		return ResponseHandler.getResponse(programs, HttpStatus.OK);
	}
	
	@PostMapping
	public Object createUser(@Valid @RequestBody CreateUserDto dto,
			BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		User newUser = service.createUser(dto);
		
		return ResponseHandler.getResponse(newUser, HttpStatus.OK);
	}
}

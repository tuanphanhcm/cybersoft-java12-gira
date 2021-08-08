package cybersoft.javabackend.java12.gira.role.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java12.gira.common.ResponseHandler;
import cybersoft.javabackend.java12.gira.role.dto.CreateRoleDto;
import cybersoft.javabackend.java12.gira.role.entity.Role;
import cybersoft.javabackend.java12.gira.role.service.itf.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	private RoleService service;
	
	public RoleController(RoleService roleService) {
		service = roleService;
	}
	
	@GetMapping
	public Object findAllRole() {
		List<Role> roles = service.findAll();
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	
	@PostMapping
	public Object saveRole(@Valid @RequestBody CreateRoleDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		
		Role addedRole = service.addNewRole(dto);
		
		return ResponseHandler.getResponse(addedRole, HttpStatus.CREATED);
	}
	
}

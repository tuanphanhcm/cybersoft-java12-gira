package cybersoft.javabackend.java12.gira.user.dto;

import java.util.Set;

import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.user.util.UserStatus;

public interface UserDto {
	// Spring Projection
	public String getUsername();
	
	public String getEmail();

	public String getFullname();

	public String getDisplayName();

	public String getAvatar();

	public UserStatus getStatus();

	public String getFacebook();

	public String getJob();

	public String getDepartment();

	public String getHobby();

	public Set<Group> getGroups();
}

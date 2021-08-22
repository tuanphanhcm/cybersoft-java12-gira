package cybersoft.javabackend.java12.gira.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java12.gira.common.entity.BaseEntity;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.user.util.UserStatus;

@Entity
@Table(name = "gira_user")
public class User extends BaseEntity {
	@NotNull
	@Column(unique = true)
	@Size(min = 3, max = 50)
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	
	private String fullname;
	private String displayName;
	private String avatar;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	private String facebook;
	private String job;
	private String department;
	private String hobby;
	
	@ManyToMany(mappedBy = "users")
	private Set<Group> groups = new HashSet<>();
	
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getFullname() {
		return fullname;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getAvatar() {
		return avatar;
	}

	public UserStatus getStatus() {
		return status;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getJob() {
		return job;
	}

	public String getDepartment() {
		return department;
	}

	public String getHobby() {
		return hobby;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
	
}

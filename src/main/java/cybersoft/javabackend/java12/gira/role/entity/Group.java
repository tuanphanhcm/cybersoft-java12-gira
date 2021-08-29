package cybersoft.javabackend.java12.gira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java12.gira.common.entity.BaseEntity;
import cybersoft.javabackend.java12.gira.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"roles", "users"})
@EqualsAndHashCode(exclude = {"roles", "users"}, callSuper = false)
@Entity
@Table(name = "gira_group")
public class Group extends BaseEntity {
	@NotNull
	@Size(min = 3, max = 50, message = "{group.name.size}")
	private String name;
	
	private String description;
	
	@Builder.Default
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "gira_group_role",
	joinColumns = @JoinColumn(name = "group_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@Builder.Default
	@JsonIgnore
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "gira_group_user",
	joinColumns = @JoinColumn(name = "group_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();
	
	// helpers
	public void addRole(Role role) {
		roles.add(role);
		role.getGroups().add(this);
	}
	
	public Group addUser(User user) {
		users.add(user);
		user.getGroups().add(this);
		return this;
	}
}

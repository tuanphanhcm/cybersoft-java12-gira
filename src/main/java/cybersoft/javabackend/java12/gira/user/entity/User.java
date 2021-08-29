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

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java12.gira.common.entity.BaseEntity;
import cybersoft.javabackend.java12.gira.role.entity.Group;
import cybersoft.javabackend.java12.gira.user.util.UserStatus;
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
@ToString(exclude = {"groups"})
@EqualsAndHashCode(exclude = {"groups"}, callSuper = false)
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
	
	@JsonIgnore
	@Builder.Default
	@ManyToMany(mappedBy = "users")
	private Set<Group> groups = new HashSet<>();
}

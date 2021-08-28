package cybersoft.javabackend.java12.gira.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {
	@NotBlank(message = "${login.username.not-blank}")
	private String username;
	@NotBlank(message = "${login.password.not-blank}")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

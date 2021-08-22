package cybersoft.javabackend.java12.gira.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsDto extends User implements UserDetails {
	public UserDetailsDto(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

}

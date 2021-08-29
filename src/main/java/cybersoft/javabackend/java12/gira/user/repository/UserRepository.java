package cybersoft.javabackend.java12.gira.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java12.gira.user.dto.UserDto;
import cybersoft.javabackend.java12.gira.user.dto.UserProgramDto;
import cybersoft.javabackend.java12.gira.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u") // JPQL
	List<UserDto> findAllUserDto();

	int countByUsername(String username);

	int countByEmail(String email);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.groups WHERE u.username = ?1")
	Optional<User> findByUsernameWithGroups(String username);

	@Query("SELECT p.name AS name, p.method AS method, p.path AS path FROM User u JOIN u.groups g JOIN g.roles r JOIN r.programs p WHERE u.username = ?1")
	List<UserProgramDto> findAllProgramsByUsername(String username);

	
}

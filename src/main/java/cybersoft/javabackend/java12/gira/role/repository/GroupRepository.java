package cybersoft.javabackend.java12.gira.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java12.gira.role.dto.GroupDto;
import cybersoft.javabackend.java12.gira.role.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

	int countByName(String groupName);

	@Query("SELECT g FROM Group g")
	List<GroupDto> findAllDto();

}

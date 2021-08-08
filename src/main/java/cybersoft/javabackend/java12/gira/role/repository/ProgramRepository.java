package cybersoft.javabackend.java12.gira.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java12.gira.role.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

}

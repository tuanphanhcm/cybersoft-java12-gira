package cybersoft.javabackend.java12.gira.common.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue
	@Column(updatable = false)
	protected Long id;
	
	@Version
	protected int version;
	
	protected String createdBy;
	protected LocalDateTime createdAt;
	protected String updatedBy;
	protected LocalDateTime updatedAt;
}

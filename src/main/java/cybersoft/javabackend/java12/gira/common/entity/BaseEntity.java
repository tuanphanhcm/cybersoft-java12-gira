package cybersoft.javabackend.java12.gira.common.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cybersoft.javabackend.java12.gira.common.util.DateUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	/*
	 * Refactor lại project
	 * 1. sử dụng lombok
	 * 2. tất cả các quan hệ trong entity được fetch kiểu lazy
	 * 3. tất cả các quan hệ trong entity được @JsonIgnore
	 * 4. format datetime thống nhất cho toàn bộ project
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	protected Long id;
	
	@Version
	protected int version;
	
	@CreatedBy
	protected String createdBy;
	
	@CreatedDate
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	protected LocalDateTime createdAt;
	
	@LastModifiedBy
	protected String updatedBy;
	
	@LastModifiedDate
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	protected LocalDateTime updatedAt;
}

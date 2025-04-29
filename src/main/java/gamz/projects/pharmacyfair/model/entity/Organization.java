package gamz.projects.pharmacyfair.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {
	@Id
	@SequenceGenerator(name = "organizations_local_seq", sequenceName = "organizations_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizations_local_seq")
	private long id;
	
	private String name;
	
	private String description;
	
	@Column(name = "created_at")
	private LocalDateTime created;
	
	@Column(name = "updated_at")
	private LocalDateTime updated;
	
	@OneToMany
	private List<User> users;
}

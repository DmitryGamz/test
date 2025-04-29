package gamz.projects.pharmacyfair.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
	@Id
	@SequenceGenerator(name = "roles_local_seq", sequenceName = "roles_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_local_seq")
	private long id;
	
	@Column(name = "role_name")
	private String name;
	
	private String description;
	
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	
	@Override
	public String getAuthority() {
		return getName();
	}
}

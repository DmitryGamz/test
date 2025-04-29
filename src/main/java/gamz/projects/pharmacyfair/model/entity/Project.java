package gamz.projects.pharmacyfair.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "projects")
public class Project {
	@Id
	@SequenceGenerator(name = "projects_local_seq", sequenceName = "projects_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_local_seq")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "short_description")
	private String shortDescription;
	
	@Column(name = "technological_readiness_level")
	private Integer technologicalReadinessLevel;
	
	@Column(name = "application_scope")
	private String applicationScope;
	
	@Column(name = "status_id")
	private Long statusId;
	
	@Column(name = "ipr_status_id")
	private Long iprStatusId;
	
	@Column(name = "ipr_valuation_exists")
	private Boolean iprValuationExists;
	
	@Column(name = "commercial_status_id")
	private Long commercialStatusId;
	
	@Column(name = "commercial_effect")
	private String commercialEffect;
	
	@Column(name = "market_perspective_id")
	private Long marketPerspectiveId;
	
	@Column(name = "novelty")
	private String novelty;
	
	@Column(name = "key_differences")
	private String keyDifferences;
	
	@Column(name = "export_potential")
	private Boolean exportPotential;
	
	@Column(name = "production_requirement_id")
	private Long productionRequirementId;
	
	@Column(name = "completion_time_id")
	private Long completionTimeId;
	
	@Column(name = "has_students_involved")
	private Boolean hasStudentsInvolved;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name = "last_edit_by")
	private Long lastEditBy;
	
	@OneToMany(mappedBy = "project")
	private List<Patent> patents;
} 
package gamz.projects.pharmacyfair.repository;

import java.util.List;

import gamz.projects.pharmacyfair.model.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findByUserId(Long userId);
} 
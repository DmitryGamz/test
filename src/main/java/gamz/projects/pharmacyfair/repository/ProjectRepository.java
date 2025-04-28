package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByUserId(Long userId);
} 
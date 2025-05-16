package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.ProjectStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectStatusRepository extends CrudRepository<ProjectStatus,Long> {
    Optional<ProjectStatus> findByCode(String code);
}

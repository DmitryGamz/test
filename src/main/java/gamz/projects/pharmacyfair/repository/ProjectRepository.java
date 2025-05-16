package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.projects.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

}

package gamz.projects.pharmacyfair.repository;

import java.util.Optional;

import gamz.projects.pharmacyfair.model.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	Optional<Role> findByName(String name);
}
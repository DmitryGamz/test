package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScopeRepository extends CrudRepository<Scope,Integer> {
    Optional<Scope> findByCode(String code);
}
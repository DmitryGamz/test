package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.RiskClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiskClassRepository extends CrudRepository<RiskClass,Long> {
    Optional<RiskClass> findByCode(String code);
}

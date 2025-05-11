package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.ProductionRequirement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductionRequirementRepository extends CrudRepository<ProductionRequirement,Long> {
    Optional<ProductionRequirement> findByCode(String code);
}

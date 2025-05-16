package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.PriorityType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityTypeRepository extends CrudRepository<PriorityType,Long> {
    Optional<PriorityType> findByCode(String code);
}
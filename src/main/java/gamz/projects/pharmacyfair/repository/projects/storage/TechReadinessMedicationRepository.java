package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.TechReadinessMedication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechReadinessMedicationRepository extends CrudRepository<TechReadinessMedication,Long> {

}

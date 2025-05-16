package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.ApplicationAreaMedication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationAreaMedicationRepository extends CrudRepository<ApplicationAreaMedication,Long> {
    Optional<ApplicationAreaMedication> findByCode(String code);
}

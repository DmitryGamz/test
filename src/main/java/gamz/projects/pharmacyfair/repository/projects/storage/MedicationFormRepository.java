package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.MedicationForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationFormRepository extends CrudRepository<MedicationForm,Long> {
    Optional<MedicationForm> findByCode(String code);
}
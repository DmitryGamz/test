package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.MedicationForm;
import gamz.projects.pharmacyfair.model.entity.projects.storage.Nkmi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NkmiRepository extends CrudRepository<Nkmi,Long> {
    Optional<Nkmi> findByCode(String code);
}

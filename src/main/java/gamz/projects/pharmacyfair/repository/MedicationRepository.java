package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {

}
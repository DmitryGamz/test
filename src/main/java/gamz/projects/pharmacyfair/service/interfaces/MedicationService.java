package gamz.projects.pharmacyfair.service.interfaces;

import gamz.projects.pharmacyfair.model.dto.MedicationDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import gamz.projects.pharmacyfair.model.exception.ProjectNotFoundException;

import java.util.List;

/**
 * A service interface for working with medicinal products.
 */
public interface MedicationService {

    /**
     * Get all medication in List.
     *
     * @return List Medication
     */
    List<Medication> findAll();

    /**
     * Find a medicine by its identifier.
     *
     * @param id medication
     * @return Medication
     * @throws ProjectNotFoundException if not found
     */
    Medication findById(Long id);

    /**
     * Create or update a medication.
     *
     * @param medicationDTO from controller for saving
     * @return сохраненный Medication с присвоенным идентификатором
     */
    Medication saveDto(MedicationDTO medicationDTO);

    /**
     * Delete a medication by ID.
     *
     * @param id medication
     */
    void deleteById(Long id);

}

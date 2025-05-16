package gamz.projects.pharmacyfair.service.impl;

import gamz.projects.pharmacyfair.model.dto.MedicationDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Medication;
import gamz.projects.pharmacyfair.model.exception.ProjectNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.MedicationMapper;
import gamz.projects.pharmacyfair.repository.MedicationRepository;
import gamz.projects.pharmacyfair.service.interfaces.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;
    private final MedicationMapper medicationMapper;

    @Override
    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication findById(Long id) {
        return medicationRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Medication with id " + id + " not found"));
    }

    @Override
    public Medication saveDto(MedicationDTO medicationDTO) {
        Medication medication = medicationMapper.fromDtoToMedication(medicationDTO);
        medication = medicationRepository.save(medication);
        return medication;
    }

    @Override
    public void deleteById(Long id) {
        medicationRepository.deleteById(id);
    }
}

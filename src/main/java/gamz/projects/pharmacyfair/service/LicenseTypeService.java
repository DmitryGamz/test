package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.LicenseTypeDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseType;
import gamz.projects.pharmacyfair.model.exception.LicenseTypeNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.LicenseTypeMapper;
import gamz.projects.pharmacyfair.model.request.LicenseTypeRequest;
import gamz.projects.pharmacyfair.repository.LicenseTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class LicenseTypeService {
    private final LicenseTypeRepository licenseTypeRepository;
    private final LicenseTypeMapper licenseTypeMapper;

    public List<LicenseTypeDTO> getAllLicenseTypes() {
        return StreamSupport.stream(licenseTypeRepository.findAll().spliterator(), false)
                .map(licenseTypeMapper::ToLicenseTypeDTO)
                .collect(Collectors.toList());
    }

    public LicenseTypeDTO getLicenseById(long id) {
        LicenseType licenseType = licenseTypeRepository.findById(id).orElseThrow(
                () -> new LicenseTypeNotFoundException("License type with ID " + id + " not found")
        );

        return licenseTypeMapper.ToLicenseTypeDTO(licenseType);
    }

    public LicenseTypeDTO createLicense(LicenseTypeRequest request) {
        LicenseType licenseType = licenseTypeMapper.FromLicenseTypeRequest(request);

        LicenseType savedLicenseType = licenseTypeRepository.save(licenseType);
        return licenseTypeMapper.ToLicenseTypeDTO(savedLicenseType);
    }

    public LicenseTypeDTO editLicenseById(Long id, LicenseTypeRequest request) {
        LicenseType licenseType = licenseTypeRepository.findById(id).orElseThrow(
                () -> new LicenseTypeNotFoundException("License type with ID " + id + " not found")
        );

        if (request.getTypeName() != null) {
            licenseType.setTypeName(request.getTypeName());
        }

        LicenseType saved = licenseTypeRepository.save(licenseType);
        return licenseTypeMapper.ToLicenseTypeDTO(saved);
    }

    public void deleteById(Long id) {
        if (! licenseTypeRepository.existsById(id)) {
            throw new LicenseTypeNotFoundException("License type with ID " + id + " not found");
        }

        licenseTypeRepository.deleteById(id);
    }
}

package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.PharmaceuticalLicenseDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseCategory;
import gamz.projects.pharmacyfair.model.entity.LicenseType;
import gamz.projects.pharmacyfair.model.entity.PharmaceuticalLicense;
import gamz.projects.pharmacyfair.model.exception.LicenseCategoryNotFoundException;
import gamz.projects.pharmacyfair.model.exception.LicenseTypeNotFoundException;
import gamz.projects.pharmacyfair.model.exception.PharmaceuticalLicenseNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.PharmaceuticalLicenseMapper;
import gamz.projects.pharmacyfair.model.request.PharmaceuticalLicenseRequest;
import gamz.projects.pharmacyfair.repository.LicenseCategoryRepository;
import gamz.projects.pharmacyfair.repository.LicenseTypeRepository;
import gamz.projects.pharmacyfair.repository.PharmaceuticalLicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PharmaceuticalLicenseService {
    private final PharmaceuticalLicenseRepository pharmaceuticalLicenseRepository;
    private final PharmaceuticalLicenseMapper pharmaceuticalLicenseMapper;
    private final LicenseCategoryRepository licenseCategoryRepository;
    private final LicenseTypeRepository licenseTypeRepository;

    public List<PharmaceuticalLicenseDTO> getAllLicenses() {
        return StreamSupport.stream(pharmaceuticalLicenseRepository.findAll().spliterator(), false)
                .map(pharmaceuticalLicenseMapper::toPharmaceuticalLicenseDTO)
                .collect(Collectors.toList());
    }

    public PharmaceuticalLicenseDTO getLicenseById(Long id) {
        PharmaceuticalLicense license = pharmaceuticalLicenseRepository.findById(id).orElseThrow(
                () -> new PharmaceuticalLicenseNotFoundException("Лицензии с ID " + id + " не найдено")
        );
        return pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(license);
    }

    public List<PharmaceuticalLicenseDTO> getLicenseByTypeId(Long typeId) {
        if (! licenseTypeRepository.existsById(typeId)) {
            throw new LicenseTypeNotFoundException("Типа лицензии с ID " + typeId + " не найдено");
        }

        return pharmaceuticalLicenseRepository.findByLicenseTypeId(typeId).stream()
                .map(pharmaceuticalLicenseMapper::toPharmaceuticalLicenseDTO)
                .collect(Collectors.toList());
    }

    public List<PharmaceuticalLicenseDTO> getLicenseByCategoryId(Long categoryId) {
        if (! licenseCategoryRepository.existsById(categoryId)) {
            throw new LicenseCategoryNotFoundException("Категории лицензии с ID " + categoryId + " не найдено");
        }

        return pharmaceuticalLicenseRepository.findByLicenseCategoryId(categoryId).stream()
                .map(pharmaceuticalLicenseMapper::toPharmaceuticalLicenseDTO)
                .collect(Collectors.toList());
    }

    public PharmaceuticalLicenseDTO createLicense(PharmaceuticalLicenseRequest request) {
        LicenseCategory category = null;
        if (request.getLicenseCategoryId() != null) {
            category = licenseCategoryRepository.findById(request.getLicenseCategoryId()).orElseThrow(
                    () -> new LicenseCategoryNotFoundException("Категории лицензии с ID " + request.getLicenseCategoryId() + " не найдено")
            );
        }

        LicenseType licenseType = null;
        if (request.getLicenseTypeId() != null) {
            licenseType = licenseTypeRepository.findById(request.getLicenseTypeId()).orElseThrow(
                    () -> new LicenseTypeNotFoundException("Типа лицензии с ID " + request.getLicenseTypeId() + " не найдено")
            );
        }

        PharmaceuticalLicense pharmaceuticalLicense = pharmaceuticalLicenseMapper.toPharmaceuticalLicenseFromRequest(request);
        pharmaceuticalLicense.setLicenseCategory(category);
        pharmaceuticalLicense.setLicenseType(licenseType);

        PharmaceuticalLicense savedLicense = pharmaceuticalLicenseRepository.save(pharmaceuticalLicense);
        return pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(savedLicense);
    }

    public PharmaceuticalLicenseDTO editLicense(Long id, PharmaceuticalLicenseRequest request) {
        PharmaceuticalLicense license = pharmaceuticalLicenseRepository.findById(id).orElseThrow(
                () -> new PharmaceuticalLicenseNotFoundException("Лицензии с ID " + id + " не найдено")
        );

        if (request.getLicenseCategoryId() != null) {
            LicenseCategory category = licenseCategoryRepository.findById(request.getLicenseCategoryId()).orElseThrow(
                    () -> new LicenseCategoryNotFoundException("Категории лицензии с ID " + request.getLicenseCategoryId() + " не найдено")
            );
            license.setLicenseCategory(category);
        }

        if (request.getLicenseTypeId() != null) {
            LicenseType licenseType = licenseTypeRepository.findById(request.getLicenseTypeId()).orElseThrow(
                    () -> new LicenseTypeNotFoundException("Типа лицензии с ID " + request.getLicenseTypeId() + " не найдено")
            );
            license.setLicenseType(licenseType);
        }

        if (request.getPartnerDetailId() != null) {
            license.setPartnerDetail(request.getPartnerDetailId());
        }

        PharmaceuticalLicense savedLicense = pharmaceuticalLicenseRepository.save(license);
        return pharmaceuticalLicenseMapper.toPharmaceuticalLicenseDTO(savedLicense);
    }

    public void deleteLicenseById(Long id) {
        if (! pharmaceuticalLicenseRepository.existsById(id)) {
            throw new PharmaceuticalLicenseNotFoundException("Лицензии с ID " + id + " не найдено");
        }

        pharmaceuticalLicenseRepository.deleteById(id);
    }
}

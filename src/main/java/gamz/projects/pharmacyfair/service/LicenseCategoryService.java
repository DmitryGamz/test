package gamz.projects.pharmacyfair.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import gamz.projects.pharmacyfair.model.dto.LicenseCategoryDTO;
import gamz.projects.pharmacyfair.model.entity.LicenseCategory;
import gamz.projects.pharmacyfair.model.exception.LicenseCategoryNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.LicenseCategoryMapper;
import gamz.projects.pharmacyfair.model.request.LicenseCategoryRequest;
import gamz.projects.pharmacyfair.repository.LicenseCategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LicenseCategoryService {
    private final LicenseCategoryRepository licenseCategoryRepository;
    private final LicenseCategoryMapper licenseCategoryMapper;

    public List<LicenseCategoryDTO> getAllLicenseCategories() {
        return StreamSupport.stream(licenseCategoryRepository.findAll().spliterator(), false)
                .map(licenseCategoryMapper::toLicenseCategoryDTO)
                .collect(Collectors.toList());
    }

    public LicenseCategoryDTO getLicenseCategoryById(Long id) {
        LicenseCategory licenseCategory = licenseCategoryRepository.findById(id).orElseThrow(
            () -> new LicenseCategoryNotFoundException("Категории лицензий с ID " + id + " не существует")
        );
        return licenseCategoryMapper.toLicenseCategoryDTO(licenseCategory);
    }

    public List<LicenseCategoryDTO> getLicenseCategoriesByParentCategoryId(Long id) {
        if (! licenseCategoryRepository.existsById(id)) {
            throw new LicenseCategoryNotFoundException("Категории лицензий с ID " + id + " не существует");
        }

        return licenseCategoryRepository.findByParentCategoryId(id).stream()
                .map(licenseCategoryMapper::toLicenseCategoryDTO)
                .collect(Collectors.toList());
    }

    public List<LicenseCategoryDTO> getLicenseCategoriesByParentCategoryIsNull() {
        return licenseCategoryRepository.findByParentCategoryIsNull().stream()
                .map(licenseCategoryMapper::toLicenseCategoryDTO)
                .collect(Collectors.toList());
    }

    public LicenseCategoryDTO createLicenseCategory(
        LicenseCategoryRequest request
    ) {
        LicenseCategory parentCategory = null;
        if (request.getParentCategoryId() != null) {
            parentCategory = licenseCategoryRepository.findById(request.getParentCategoryId()).orElseThrow(
                () -> new LicenseCategoryNotFoundException("Родительской категории лицензий с ID " + request.getParentCategoryId() + " не существует")
            );
        }
        LicenseCategory licenseCategory = licenseCategoryMapper.toLicenseCategoryFromRequest(request);

        licenseCategory.setParentCategory(parentCategory);

        LicenseCategory savedLicenseCategory = licenseCategoryRepository.save(licenseCategory);
        return licenseCategoryMapper.toLicenseCategoryDTO(savedLicenseCategory);
    }

    public LicenseCategoryDTO editLicenseCategory(
        Long id,
        LicenseCategoryRequest editRequest
    ) {
        LicenseCategory licenseCategory = licenseCategoryRepository.findById(id).orElseThrow(
            () -> new LicenseCategoryNotFoundException("Категории лицензий с ID " + id + " не существует")
        );

        if (editRequest.getCategoryName() != null) {
            licenseCategory.setCategoryName(editRequest.getCategoryName());
        }

        if (editRequest.getParentCategoryId() != null) {
            LicenseCategory parentCategory = licenseCategoryRepository.findById(editRequest.getParentCategoryId()).orElseThrow(
                    () -> new LicenseCategoryNotFoundException("Родительской категории лицензий с ID " + editRequest.getParentCategoryId() + " не существует")
            );
            licenseCategory.setParentCategory(parentCategory);
        }

        LicenseCategory savedLicenseCategory = licenseCategoryRepository.save(licenseCategory);
        return licenseCategoryMapper.toLicenseCategoryDTO(savedLicenseCategory);
    }

    public void deleteLicenseCategory(Long id) {
        if (! licenseCategoryRepository.existsById(id)) {
            throw new LicenseCategoryNotFoundException("Категории лицензий с ID " + id + " не существует");
        }

        licenseCategoryRepository.deleteById(id);
    }
}

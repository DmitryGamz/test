package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.PharmaceuticalLicense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmaceuticalLicenseRepository extends CrudRepository<PharmaceuticalLicense, Long> {
    List<PharmaceuticalLicense> findByLicenseTypeId(long licenseTypeId);

    List<PharmaceuticalLicense> findByLicenseCategoryId(long categoryId);
}

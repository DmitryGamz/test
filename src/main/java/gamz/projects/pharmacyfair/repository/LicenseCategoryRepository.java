package gamz.projects.pharmacyfair.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gamz.projects.pharmacyfair.model.entity.LicenseCategory;

import java.util.List;

@Repository
public interface LicenseCategoryRepository extends CrudRepository<LicenseCategory, Long> {
    List<LicenseCategory> findByParentCategoryId(Long id);
    List<LicenseCategory> findByParentCategoryIsNull();
}

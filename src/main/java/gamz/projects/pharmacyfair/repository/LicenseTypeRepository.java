package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.LicenseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseTypeRepository extends CrudRepository<LicenseType, Long> {}

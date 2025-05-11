package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.TechReadinessDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TechReadinessDeviceRepository extends CrudRepository<TechReadinessDevice,Long> {
    Optional<TechReadinessDevice> findByCode(String code);
}
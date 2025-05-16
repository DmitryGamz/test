package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.CommercialStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommercialStatusRepository extends CrudRepository<CommercialStatus,Long> {
    Optional<CommercialStatus> findByCode(String code);
}


package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.IprStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IprStatusRepository extends CrudRepository<IprStatus,Long> {
    Optional<IprStatus> findByCode(String code);
}
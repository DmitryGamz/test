package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.CompletionTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompletionTimeRepository extends CrudRepository<CompletionTime,Integer> {
    Optional<CompletionTime> findByCode(String code);
}
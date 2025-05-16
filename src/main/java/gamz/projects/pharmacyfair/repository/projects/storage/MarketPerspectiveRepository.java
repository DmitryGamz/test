package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.MarketPerspective;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketPerspectiveRepository extends CrudRepository<MarketPerspective,Long> {
    Optional<MarketPerspective> findByCode(String code);
}

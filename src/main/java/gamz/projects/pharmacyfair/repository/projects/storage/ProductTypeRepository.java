package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType,Integer> {
    Optional<ProductType> findByCode(String code);
}

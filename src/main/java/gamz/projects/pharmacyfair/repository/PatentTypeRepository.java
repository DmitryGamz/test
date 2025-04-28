package gamz.projects.pharmacyfair.repository;

import java.util.Optional;

import gamz.projects.pharmacyfair.model.entity.PatentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatentTypeRepository extends CrudRepository<PatentType, Long> {
	Optional<PatentType> findByTypeCode(String typeCode);
	
	Optional<PatentType> findByTypeName(String typeName);
} 
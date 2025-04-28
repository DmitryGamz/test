package gamz.projects.pharmacyfair.repository;

import java.util.List;

import gamz.projects.pharmacyfair.model.entity.Patent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatentRepository extends CrudRepository<Patent, Long> {
	List<Patent> findByProjectId(Long projectId);
	
	List<Patent> findByPatentTypeId(Long patentTypeId);
} 
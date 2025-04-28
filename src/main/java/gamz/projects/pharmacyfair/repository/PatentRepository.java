package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.Patent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatentRepository extends CrudRepository<Patent, Long> {
    List<Patent> findByProjectId(Long projectId);
    List<Patent> findByPatentTypeId(Long patentTypeId);
} 
package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.FileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileTypeRepository extends JpaRepository<FileType, Long> {
}

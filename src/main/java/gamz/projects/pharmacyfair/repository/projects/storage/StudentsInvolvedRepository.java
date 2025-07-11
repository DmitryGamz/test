package gamz.projects.pharmacyfair.repository.projects.storage;

import gamz.projects.pharmacyfair.model.entity.projects.storage.StudentsInvolved;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsInvolvedRepository extends CrudRepository<StudentsInvolved,Long> {
    Optional<StudentsInvolved> findByCode(String code);
}

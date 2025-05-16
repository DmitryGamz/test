package gamz.projects.pharmacyfair.repository;

import java.util.Optional;

import gamz.projects.pharmacyfair.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}

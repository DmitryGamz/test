package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SettingsRepository extends JpaRepository<Setting, String> {
    Boolean existsByKey(String key);

    void deleteByKey(String key);

    Optional<Setting> findByKey(String key);
}


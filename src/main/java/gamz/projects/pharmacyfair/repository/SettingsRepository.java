package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<Setting, String> {
}


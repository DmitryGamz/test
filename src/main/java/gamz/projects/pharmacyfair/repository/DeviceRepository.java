package gamz.projects.pharmacyfair.repository;

import gamz.projects.pharmacyfair.model.entity.projects.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {

}

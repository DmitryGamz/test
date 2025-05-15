package gamz.projects.pharmacyfair.service.interfaces;

import gamz.projects.pharmacyfair.model.dto.DeviceDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.exception.ProjectNotFoundException;

import java.util.List;

/**
 * A service interface for working with devices.
 */
public interface DeviceService {

    /**
     * Get all devices in a List.
     *
     * @return List of Device
     */
    List<Device> findAll();

    /**
     * Find a device by its identifier.
     *
     * @param id device ID
     * @return Device
     * @throws ProjectNotFoundException if not found
     */
    Device findById(Long id);

    /**
     * Create or update a device.
     *
     * @param deviceDTO DTO from controller for saving
     * @return saved Device with assigned identifier
     */
    Device saveDto(DeviceDTO deviceDTO);

    /**
     * Delete a device by ID.
     *
     * @param id device ID
     */
    void deleteById(Long id);

}
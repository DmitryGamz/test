package gamz.projects.pharmacyfair.service.impl;

import gamz.projects.pharmacyfair.model.dto.DeviceDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.exception.ProjectNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.DeviceMapper;
import gamz.projects.pharmacyfair.repository.DeviceRepository;
import gamz.projects.pharmacyfair.service.interfaces.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device findById(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Device with id " + id + " not found"));
    }

    @Override
    public Device saveDto(DeviceDTO deviceDTO) {
        Device device = deviceMapper.fromDtoToDevice(deviceDTO);
        return deviceRepository.save(device);
    }

    @Override
    public void deleteById(Long id) {
        deviceRepository.deleteById(id);
    }
}
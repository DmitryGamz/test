package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.model.dto.DeviceDTO;
import gamz.projects.pharmacyfair.model.dto.ReferenceDTO;
import gamz.projects.pharmacyfair.model.entity.projects.Device;
import gamz.projects.pharmacyfair.model.mapper.ProjectMapper;
import gamz.projects.pharmacyfair.service.ReferenceService;
import gamz.projects.pharmacyfair.service.impl.DeviceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class DeviceControllerTest {

    private DeviceServiceImpl deviceService;
    private ProjectMapper mapper;
    private ReferenceService referenceService;
    private DeviceController controller;

    @BeforeEach
    void setup() {
        deviceService = mock(DeviceServiceImpl.class);
        mapper = mock(ProjectMapper.class);
        referenceService = mock(ReferenceService.class);

        controller = new DeviceController(deviceService, mapper, referenceService);
    }

    @Test
    void testGetAll() {
        Device device = new Device();
        device.setId(1L);

        DeviceDTO dto = new DeviceDTO();
        dto.setId(1L);

        when(deviceService.findAll()).thenReturn(List.of(device));
        when(mapper.fromDeviceToDto(device)).thenReturn(dto);

        ResponseEntity<List<DeviceDTO>> response = controller.getAll();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0).getId()).isEqualTo(1L);

        verify(deviceService).findAll();
        verify(mapper).fromDeviceToDto(device);
    }

    @Test
    void testGetById() {
        Device device = new Device();
        device.setId(10L);
        DeviceDTO dto = new DeviceDTO();
        dto.setId(10L);

        when(deviceService.findById(10L)).thenReturn(device);
        when(mapper.fromDeviceToDto(device)).thenReturn(dto);

        ResponseEntity<DeviceDTO> response = controller.getById(10L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(10L);

        verify(deviceService).findById(10L);
        verify(mapper).fromDeviceToDto(device);
    }

    @Test
    void testSave_conflictId() {
        DeviceDTO dto = new DeviceDTO();
        dto.setId(5L);

        // id path variable не совпадает с dto.id
        ResponseEntity<DeviceDTO> response = controller.save(dto, 10L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
        verifyNoInteractions(deviceService);
    }

    @Test
    void testSave_success() {
        DeviceDTO dto = new DeviceDTO();
        dto.setId(10L);

        Device device = new Device();
        device.setId(10L);

        when(deviceService.saveDto(dto)).thenReturn(device);
        when(mapper.fromDeviceToDto(device)).thenReturn(dto);

        ResponseEntity<DeviceDTO> response = controller.save(dto, 10L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(10L);

        verify(deviceService).saveDto(dto);
        verify(mapper).fromDeviceToDto(device);
    }

    @Test
    void testDelete() {
        doNothing().when(deviceService).deleteById(7L);

        ResponseEntity<Void> response = controller.delete(7L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        verify(deviceService).deleteById(7L);
    }

    @Test
    void testGetAllReferenceByName() {
        ReferenceDTO ref = new ReferenceDTO();
        when(referenceService.getReference("someName", "device", null)).thenReturn(List.of(ref));

        ResponseEntity<List<ReferenceDTO>> response = controller.getAllReferenceByName("someName");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);

        verify(referenceService).getReference("someName", "device", null);
    }

    @Test
    void testGetOneReferenceByNameAndId() {
        ReferenceDTO ref = new ReferenceDTO();
        when(referenceService.getReference("someName", "device", 5L)).thenReturn(List.of(ref));

        ResponseEntity<List<ReferenceDTO>> response = controller.getOneReferenceByNameAndId("someName", 5L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);

        verify(referenceService).getReference("someName", "device", 5L);
    }
}

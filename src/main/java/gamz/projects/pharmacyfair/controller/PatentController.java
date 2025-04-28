package gamz.projects.pharmacyfair.controller;

import java.util.List;

import gamz.projects.pharmacyfair.model.dto.PatentDTO;
import gamz.projects.pharmacyfair.model.request.PatentRequest;
import gamz.projects.pharmacyfair.service.PatentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patents")
@RequiredArgsConstructor
@Tag(name = "Patents", description = "API для работы с патентами")
public class PatentController {
	
	private final PatentService patentService;
	
	@GetMapping
	@Operation(summary = "Получить все патенты")
	public ResponseEntity<List<PatentDTO>> getAllPatents() {
		return ResponseEntity.ok(patentService.getAllPatents());
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Получить патент по ID")
	public ResponseEntity<PatentDTO> getPatentById(
			@Parameter(description = "ID патента") @PathVariable Long id) {
		return ResponseEntity.ok(patentService.getPatentById(id));
	}
	
	@GetMapping("/project/{projectId}")
	@Operation(summary = "Получить патенты по ID проекта")
	public ResponseEntity<List<PatentDTO>> getPatentsByProjectId(
			@Parameter(description = "ID проекта") @PathVariable Long projectId) {
		return ResponseEntity.ok(patentService.getPatentsByProjectId(projectId));
	}
	
	@GetMapping("/type/{patentTypeId}")
	@Operation(summary = "Получить патенты по ID типа патента")
	public ResponseEntity<List<PatentDTO>> getPatentsByPatentTypeId(
			@Parameter(description = "ID типа патента") @PathVariable Long patentTypeId) {
		return ResponseEntity.ok(patentService.getPatentsByPatentTypeId(patentTypeId));
	}
	
	@PostMapping
	@Operation(summary = "Создать новый патент")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PatentDTO> createPatent(
			@Parameter(description = "Данные патента") @RequestBody PatentRequest request) {
		return new ResponseEntity<>(patentService.createPatent(request), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Обновить патент")
	public ResponseEntity<PatentDTO> updatePatent(
			@Parameter(description = "ID патента") @PathVariable Long id,
			@Parameter(description = "Обновленные данные патента") @RequestBody PatentRequest request) {
		return ResponseEntity.ok(patentService.updatePatent(id, request));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Удалить патент")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deletePatent(
			@Parameter(description = "ID патента") @PathVariable Long id) {
		patentService.deletePatent(id);
		return ResponseEntity.noContent().build();
	}
} 
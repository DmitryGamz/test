package gamz.projects.pharmacyfair.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import gamz.projects.pharmacyfair.model.dto.PatentDTO;
import gamz.projects.pharmacyfair.model.entity.Patent;
import gamz.projects.pharmacyfair.model.entity.PatentType;
import gamz.projects.pharmacyfair.model.entity.projects.Project;
import gamz.projects.pharmacyfair.model.exception.PatentNotFoundException;
import gamz.projects.pharmacyfair.model.exception.PatentTypeNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.PatentMapper;
import gamz.projects.pharmacyfair.model.request.PatentRequest;
import gamz.projects.pharmacyfair.repository.PatentRepository;
import gamz.projects.pharmacyfair.repository.PatentTypeRepository;
import gamz.projects.pharmacyfair.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatentService {
	
	private final PatentRepository patentRepository;
	private final PatentTypeRepository patentTypeRepository;
	private final ProjectRepository projectRepository;
	private final PatentMapper patentMapper;
	
	public List<PatentDTO> getAllPatents() {
		return StreamSupport.stream(patentRepository.findAll().spliterator(), false)
				.map(patentMapper::toPatentDTO)
				.toList();
	}
	
	public PatentDTO getPatentById(Long id) {
		Patent patent = patentRepository.findById(id)
				.orElseThrow(() -> new PatentNotFoundException("Patent with id " + id + " not found"));
		return patentMapper.toPatentDTO(patent);
	}
	
	public List<PatentDTO> getPatentsByProjectId(Long projectId) {
		return patentRepository.findByProjectId(projectId).stream()
				.map(patentMapper::toPatentDTO)
				.toList();
	}
	
	public List<PatentDTO> getPatentsByPatentTypeId(Long patentTypeId) {
		return patentRepository.findByPatentTypeId(patentTypeId).stream()
				.map(patentMapper::toPatentDTO)
				.toList();
	}
	
	public PatentDTO createPatent(PatentRequest patentRequest) {
		Patent patent = patentMapper.toPatentFromRequest(patentRequest);
		
		Project project = projectRepository.findById(patentRequest.getProjectId())
				.orElseThrow(() -> new RuntimeException("Project with id " + patentRequest.getProjectId() + " not found"));
		patent.setProject(project);
		
		PatentType patentType = patentTypeRepository.findById(patentRequest.getPatentTypeId())
				.orElseThrow(() -> new PatentTypeNotFoundException("Patent type with id " + patentRequest.getPatentTypeId() + " not found"));
		patent.setPatentType(patentType);
		
		patent.setCreatedAt(LocalDateTime.now());
		patent.setUpdatedAt(LocalDateTime.now());
		
		Patent savedPatent = patentRepository.save(patent);
		return patentMapper.toPatentDTO(savedPatent);
	}
	
	public PatentDTO updatePatent(Long id, PatentRequest patentRequest) {
		Patent existingPatent = patentRepository.findById(id)
				.orElseThrow(() -> new PatentNotFoundException("Patent with id " + id + " not found"));
		
		if (patentRequest.getProjectId() != null) {
			Project project = projectRepository.findById(patentRequest.getProjectId())
					.orElseThrow(() -> new RuntimeException("Project with id " + patentRequest.getProjectId() + " not found"));
			existingPatent.setProject(project);
		}
		
		if (patentRequest.getPatentTypeId() != null) {
			PatentType patentType = patentTypeRepository.findById(patentRequest.getPatentTypeId())
					.orElseThrow(() -> new PatentTypeNotFoundException("Patent type with id " + patentRequest.getPatentTypeId() + " not found"));
			existingPatent.setPatentType(patentType);
		}
		
		if (patentRequest.getPatentNumber() != null) {
			existingPatent.setPatentNumber(patentRequest.getPatentNumber());
		}
		
		if (patentRequest.getExpiryDate() != null) {
			existingPatent.setExpiryDate(patentRequest.getExpiryDate());
		}
		
		if (patentRequest.getPatentOwnerId() != null) {
			existingPatent.setPatentOwnerId(patentRequest.getPatentOwnerId());
		}
		
		if (patentRequest.getApplicationNumber() != null) {
			existingPatent.setApplicationNumber(patentRequest.getApplicationNumber());
		}
		
		if (patentRequest.getFilingDate() != null) {
			existingPatent.setFilingDate(patentRequest.getFilingDate());
		}
		
		if (patentRequest.getApplicantId() != null) {
			existingPatent.setApplicantId(patentRequest.getApplicantId());
		}
		
		existingPatent.setUpdatedAt(LocalDateTime.now());
		
		Patent updatedPatent = patentRepository.save(existingPatent);
		return patentMapper.toPatentDTO(updatedPatent);
	}
	
	public void deletePatent(Long id) {
		if (!patentRepository.existsById(id)) {
			throw new PatentNotFoundException("Patent with id " + id + " not found");
		}
		patentRepository.deleteById(id);
	}
} 
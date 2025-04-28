package gamz.projects.pharmacyfair.service;

import gamz.projects.pharmacyfair.model.dto.PatentTypeDTO;
import gamz.projects.pharmacyfair.model.entity.PatentType;
import gamz.projects.pharmacyfair.model.exception.PatentTypeNotFoundException;
import gamz.projects.pharmacyfair.model.mapper.PatentTypeMapper;
import gamz.projects.pharmacyfair.model.request.PatentTypeRequest;
import gamz.projects.pharmacyfair.repository.PatentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PatentTypeService {

    private final PatentTypeRepository patentTypeRepository;
    private final PatentTypeMapper patentTypeMapper;

    public List<PatentTypeDTO> getAllPatentTypes() {
        return StreamSupport.stream(patentTypeRepository.findAll().spliterator(), false)
                .map(patentTypeMapper::toPatentTypeDTO)
                .collect(Collectors.toList());
    }

    public PatentTypeDTO getPatentTypeById(Long id) {
        PatentType patentType = patentTypeRepository.findById(id)
                .orElseThrow(() -> new PatentTypeNotFoundException("Patent type with id " + id + " not found"));
        return patentTypeMapper.toPatentTypeDTO(patentType);
    }

    public PatentTypeDTO getPatentTypeByTypeCode(String typeCode) {
        PatentType patentType = patentTypeRepository.findByTypeCode(typeCode)
                .orElseThrow(() -> new PatentTypeNotFoundException("Patent type with code " + typeCode + " not found"));
        return patentTypeMapper.toPatentTypeDTO(patentType);
    }

    public PatentTypeDTO getPatentTypeByTypeName(String typeName) {
        PatentType patentType = patentTypeRepository.findByTypeName(typeName)
                .orElseThrow(() -> new PatentTypeNotFoundException("Patent type with name " + typeName + " not found"));
        return patentTypeMapper.toPatentTypeDTO(patentType);
    }

    public PatentTypeDTO createPatentType(PatentTypeRequest patentTypeRequest) {
        PatentType patentType = patentTypeMapper.toPatentTypeFromRequest(patentTypeRequest);
        PatentType savedPatentType = patentTypeRepository.save(patentType);
        return patentTypeMapper.toPatentTypeDTO(savedPatentType);
    }

    public PatentTypeDTO updatePatentType(Long id, PatentTypeRequest patentTypeRequest) {
        PatentType existingPatentType = patentTypeRepository.findById(id)
                .orElseThrow(() -> new PatentTypeNotFoundException("Patent type with id " + id + " not found"));
        
        if (patentTypeRequest.getTypeCode() != null) {
            existingPatentType.setTypeCode(patentTypeRequest.getTypeCode());
        }
        
        if (patentTypeRequest.getTypeName() != null) {
            existingPatentType.setTypeName(patentTypeRequest.getTypeName());
        }
        
        if (patentTypeRequest.getDescription() != null) {
            existingPatentType.setDescription(patentTypeRequest.getDescription());
        }
        
        PatentType updatedPatentType = patentTypeRepository.save(existingPatentType);
        return patentTypeMapper.toPatentTypeDTO(updatedPatentType);
    }

    public void deletePatentType(Long id) {
        if (!patentTypeRepository.existsById(id)) {
            throw new PatentTypeNotFoundException("Patent type with id " + id + " not found");
        }
        patentTypeRepository.deleteById(id);
    }
} 
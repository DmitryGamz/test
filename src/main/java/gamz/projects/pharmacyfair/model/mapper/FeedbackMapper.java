package gamz.projects.pharmacyfair.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import gamz.projects.pharmacyfair.model.dto.FeedbackDTO;
import gamz.projects.pharmacyfair.model.entity.Feedback;
import gamz.projects.pharmacyfair.model.request.FeedbackRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeedbackMapper {

	@Mapping(target = "processedBy.id", source = "processedBy")
    Feedback toFeedbackFromRequest(FeedbackRequest request);

	@Mapping(target = "processedBy", source = "processedBy.id")
	FeedbackDTO toFeedbackDTO(Feedback patent);

}

package gamz.projects.pharmacyfair.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import gamz.projects.pharmacyfair.model.entity.Feedback;
import gamz.projects.pharmacyfair.model.request.FeedbackCreateRequest;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeedbackMapper {

    Feedback toFeedbackFromCreateRequest(FeedbackCreateRequest request);

}

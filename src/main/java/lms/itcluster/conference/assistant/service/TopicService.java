package lms.itcluster.conference.assistant.service;

import lms.itcluster.conference.assistant.service.dto.TopicDto;

import java.util.List;

public interface TopicService {

    TopicDto findById(long id);
    List<TopicDto> findByConfId(long confId);

}

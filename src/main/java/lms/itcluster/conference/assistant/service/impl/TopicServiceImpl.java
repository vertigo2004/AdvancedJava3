package lms.itcluster.conference.assistant.service.impl;

import lms.itcluster.conference.assistant.repo.TopicRepository;
import lms.itcluster.conference.assistant.service.TopicService;
import lms.itcluster.conference.assistant.service.dto.TopicDto;
import lms.itcluster.conference.assistant.service.dto.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public TopicDto findById(long id) {
        return TopicMapper.toDto(topicRepository.findById(id).get());
    }

    @Override
    public List<TopicDto> findByConfId(long confId) {
        return TopicMapper.toDtos(topicRepository.findByConferenceId(confId));
    }

}

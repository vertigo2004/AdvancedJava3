package lms.itcluster.conference.assistant.service.impl;

import lms.itcluster.conference.assistant.exception.NoSuchTopicException;
import lms.itcluster.conference.assistant.repo.TopicRepository;
import lms.itcluster.conference.assistant.service.TopicService;
import lms.itcluster.conference.assistant.service.dto.TopicDto;
import lms.itcluster.conference.assistant.service.dto.mapper.TopicMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public TopicDto findById(long id) {
        try {
            return TopicMapper.toDto(topicRepository.findById(id).get());
        } catch (NoSuchElementException e) {
            log.warn("Can't find Topic with Id: {}", id);
            throw new NoSuchTopicException();
        }
    }

    @Override
    public List<TopicDto> findByConfId(long confId) {
        return TopicMapper.toDtos(topicRepository.findByConferenceId(confId));
    }

}

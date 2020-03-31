package lms.itcluster.conference.assistant.service.impl;

import lms.itcluster.conference.assistant.exception.NoSuchConferenceException;
import lms.itcluster.conference.assistant.repo.ConferenceRepository;
import lms.itcluster.conference.assistant.service.ConferenceService;
import lms.itcluster.conference.assistant.service.dto.ConferenceDto;
import lms.itcluster.conference.assistant.service.dto.mapper.ConferenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Override
    public ConferenceDto findById(long id) {
        try {
            return ConferenceMapper.toDto(conferenceRepository.findById(id).get());
        } catch (NoSuchElementException e) {
            throw new NoSuchConferenceException();
        }

    }

    @Override
    public List<ConferenceDto> findAll() {
        return ConferenceMapper.toDtos(conferenceRepository.findAll());
    }
}

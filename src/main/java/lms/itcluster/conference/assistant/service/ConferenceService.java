package lms.itcluster.conference.assistant.service;

import lms.itcluster.conference.assistant.service.dto.ConferenceDto;

import java.util.List;

public interface ConferenceService {

    ConferenceDto findById(long id);
    List<ConferenceDto> findAll();

}

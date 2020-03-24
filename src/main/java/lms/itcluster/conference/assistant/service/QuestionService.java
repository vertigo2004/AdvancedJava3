package lms.itcluster.conference.assistant.service;

import lms.itcluster.conference.assistant.domain.Question;
import lms.itcluster.conference.assistant.service.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto getQuestionById(long id, String email);
    List<QuestionDto> getQuestionByTopicId(long topicId, String email);

    QuestionDto addQuestion(QuestionDto dto);
}

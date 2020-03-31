package lms.itcluster.conference.assistant.service.impl;

import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.domain.Question;
import lms.itcluster.conference.assistant.domain.Topic;
import lms.itcluster.conference.assistant.repo.GuestRepository;
import lms.itcluster.conference.assistant.repo.QuestionRepository;
import lms.itcluster.conference.assistant.repo.TopicRepository;
import lms.itcluster.conference.assistant.service.QuestionService;
import lms.itcluster.conference.assistant.service.dto.QuestionDto;
import lms.itcluster.conference.assistant.service.dto.mapper.QuestionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    TopicRepository topicRepository;

    @Override
    public QuestionDto getQuestionById(long id, String email) {
        Question q = questionRepository.findById(id).get();
        Guest guest = guestRepository.getByEmail(email);

        Set<Guest> likes = q.getLikes();
        return QuestionMapper.toDto(q, likes.contains(guest), likes.size());
    }

    @Override
    public List<QuestionDto> getQuestionByTopicId(long topicId, String email) {
        Guest guest = guestRepository.getByEmail(email);
        return questionRepository
                .findByTopicId(topicId)
                .stream()
                .map((e) -> {
                    Set<Guest> likes = e.getLikes();
            return QuestionMapper.toDto(e, e.getLikes().contains(guest), likes.size());
        }
        ).collect(Collectors.toList());
    }

    @Override
    public QuestionDto addQuestion(QuestionDto dto) {
        Question question = QuestionMapper.fromDto(dto);
        Topic t = topicRepository.findById(dto.getTopicId()).get();
        question.setTopic(t);
        Guest author = guestRepository.findById(dto.getAuthorId()).get();
        question.setAuthor(author);
        question.setLikes(new HashSet<>(Arrays.asList(author)));

        return QuestionMapper.toDto(questionRepository.save(question), true, question.getLikes().size());
    }

    @Override
    public QuestionDto like(long questionId, long guestId) {
        Guest guest = guestRepository.findById(guestId).get();
        Question question = questionRepository.findById(questionId).get();
        question.getLikes().add(guest);

        return QuestionMapper.toDto(questionRepository.save(question), true, question.getLikes().size());
    }

}

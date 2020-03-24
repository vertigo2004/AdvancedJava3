package lms.itcluster.conference.assistant.service.dto.mapper;

import lms.itcluster.conference.assistant.domain.Guest;
import lms.itcluster.conference.assistant.domain.Question;
import lms.itcluster.conference.assistant.domain.Topic;
import lms.itcluster.conference.assistant.service.dto.QuestionDto;

public class QuestionMapper {
    public static QuestionDto toDto(Question e, boolean isLiked, int liked) {

        return new QuestionDto(e.getId(), e.getBody(), e.getAuthor().getId(), e.getTopic().getId(), isLiked, liked);
    }

    public static Question fromDto(QuestionDto dto) {
        Question q = new Question();
        q.setBody(dto.getBody());
        Topic topic = new Topic();
        topic.setId(dto.getTopicId());
        q.setTopic(topic);
        Guest g = new Guest();
        g.setId(dto.getAuthorId());

        return q;
    }
}

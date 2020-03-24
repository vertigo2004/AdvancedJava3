package lms.itcluster.conference.assistant.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionDto {

    private Long id;
    private String body;
    private Long authorId;
    private Long topicId;
    Boolean isLikedByGuest;
    Integer liked;
}

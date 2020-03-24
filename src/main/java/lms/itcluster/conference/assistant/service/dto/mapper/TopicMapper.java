package lms.itcluster.conference.assistant.service.dto.mapper;

import lms.itcluster.conference.assistant.domain.Conference;
import lms.itcluster.conference.assistant.domain.Topic;
import lms.itcluster.conference.assistant.service.dto.TopicDto;

import java.util.List;
import java.util.stream.Collectors;

public class TopicMapper {

    public static TopicDto toDto(Topic entity) {
        return new TopicDto(entity.getId(), entity.getTitle(), entity.getSpeaker(), entity.getAnnotation(),
                entity.getConference().getId());
    }

    public static Topic fromDto(TopicDto dto) {
        Topic t = new Topic();
        t.setId(dto.getId());
        t.setTitle(dto.getTitle());
        t.setSpeaker(dto.getSpeaker());
        t.setAnnotation(dto.getAnnotation());
        Conference c = new Conference();
        c.setId(dto.getConfId());
        t.setConference(c);
        return t;
    }

    public static List<TopicDto> toDtos(List<Topic> entities) {
        return entities
                .stream()
                .map((e) -> new TopicDto(e.getId(), e.getTitle(), e.getSpeaker(), e.getAnnotation(),
                        e.getConference().getId()))
                .collect(Collectors.toList());
    }

    public static List<Topic> fromDtos(List<TopicDto> dtos) {
        return dtos
                .stream()
                .map(TopicMapper::fromDto)
                .collect(Collectors.toList());
    }
}

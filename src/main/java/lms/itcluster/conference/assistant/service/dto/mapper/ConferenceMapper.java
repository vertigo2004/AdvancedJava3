package lms.itcluster.conference.assistant.service.dto.mapper;

import lms.itcluster.conference.assistant.domain.Conference;
import lms.itcluster.conference.assistant.service.dto.ConferenceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class ConferenceMapper {
    public static ConferenceDto toDto(Conference entity) {
        return new ConferenceDto(entity.getId(), entity.getName(), entity.getDate(), entity.getVenue(), entity.getDescription());
    }

    public static Conference fromDto(ConferenceDto dto) {
        Conference c = new Conference();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setDate(dto.getDate());
        c.setVenue(dto.getVenue());
        c.setDescription(dto.getDescription());
        return c;
    }

    public static List<ConferenceDto> toDtos(List<Conference> entities) {
        return entities
                .stream()
                .map((e) -> new ConferenceDto(e.getId(), e.getName(), e.getDate(), e.getVenue(), e.getDescription()))
                .collect(Collectors.toList());
    }

    public static List<Conference> fromDtos(List<ConferenceDto> dtos) {
        return dtos
                .stream()
                .map(ConferenceMapper::fromDto)
                .collect(Collectors.toList());
    }
}

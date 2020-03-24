package lms.itcluster.conference.assistant.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ConferenceDto {

    private long id;
    private String name;
    private Date date;
    private String venue;
    private String description;
}

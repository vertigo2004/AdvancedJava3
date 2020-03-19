package lms.itcluster.conference.assistant.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Conference {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date date;
    private String venue;
    private String description;

}

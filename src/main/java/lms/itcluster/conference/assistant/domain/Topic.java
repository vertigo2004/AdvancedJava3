package lms.itcluster.conference.assistant.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String speaker;
    private String annotation;

    @ManyToOne
    private Conference conference;
}

package lms.itcluster.conference.assistant.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Photo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="orgfnization_id" , nullable=false)
    private Organization organization;

}

package lms.itcluster.conference.assistant.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
public class Organization {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo_id", referencedColumnName = "id")
    private Photo logo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization", fetch = FetchType.EAGER)
    private List<Photo> photos;

}

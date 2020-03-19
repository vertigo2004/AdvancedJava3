package lms.itcluster.conference.assistant.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Guest {

    @Id
    @GeneratedValue
    private Long id;
    private String email;

    @ManyToMany(mappedBy = "likes")
    private Set<Question> liked;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return id.equals(guest.id) &&
                email.equals(guest.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}

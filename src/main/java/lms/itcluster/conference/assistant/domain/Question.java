package lms.itcluster.conference.assistant.domain;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private String body;

    @ManyToOne
    private Guest author;

    @ManyToOne
    private Topic topic;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "question_likes",
    joinColumns = @JoinColumn(name = "question_id"),
    inverseJoinColumns = @JoinColumn(name = "guest_id"))
    private Set<Guest> likes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id.equals(question.id) &&
                body.equals(question.body) &&
                author.equals(question.author) &&
                topic.equals(question.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, author, topic);
    }
}

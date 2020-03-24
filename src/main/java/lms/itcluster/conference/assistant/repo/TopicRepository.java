package lms.itcluster.conference.assistant.repo;

import lms.itcluster.conference.assistant.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByConferenceId(long id);

}

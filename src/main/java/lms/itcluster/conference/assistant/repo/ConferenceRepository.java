package lms.itcluster.conference.assistant.repo;

import lms.itcluster.conference.assistant.domain.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    List<Conference> findByNameIsLike(String name);
}

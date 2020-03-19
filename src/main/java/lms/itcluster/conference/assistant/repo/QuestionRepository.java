package lms.itcluster.conference.assistant.repo;

import lms.itcluster.conference.assistant.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}

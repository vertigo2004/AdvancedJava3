package lms.itcluster.conference.assistant.repo;

import lms.itcluster.conference.assistant.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}

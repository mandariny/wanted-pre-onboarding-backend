package wanted.pre.onboarding.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.pre.onboarding.jobportal.domain.Recruit;

import java.util.List;
import java.util.Optional;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
    Optional<List<Recruit>> findByCompanyId(Long id);
}

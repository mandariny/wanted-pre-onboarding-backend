package wanted.pre.onboarding.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.pre.onboarding.jobportal.domain.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication ,Long> {
}

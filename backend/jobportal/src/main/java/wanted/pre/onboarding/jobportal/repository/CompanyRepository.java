package wanted.pre.onboarding.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.pre.onboarding.jobportal.domain.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);
}

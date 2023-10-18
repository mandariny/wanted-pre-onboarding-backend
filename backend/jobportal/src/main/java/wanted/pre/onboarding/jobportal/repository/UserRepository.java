package wanted.pre.onboarding.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wanted.pre.onboarding.jobportal.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
}

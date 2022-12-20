package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Long> {
}

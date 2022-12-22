package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationGroupRepository extends JpaRepository<RegistrationGroup,Long> {
   Optional<RegistrationGroup> findByName(String name);
}

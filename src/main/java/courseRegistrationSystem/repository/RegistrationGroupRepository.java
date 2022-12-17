package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationGroupRepository extends JpaRepository<RegistrationGroup,Long> {
}

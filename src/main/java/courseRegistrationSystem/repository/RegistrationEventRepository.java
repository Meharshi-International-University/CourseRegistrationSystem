package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Course;
import courseRegistrationSystem.domain.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent,Long> {

}

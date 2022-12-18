package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.domain.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest,Long> {

}

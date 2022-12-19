package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.domain.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest,Long> {
    @Query("select r from RegistrationRequest r  where r.id=:id")
    RegistrationRequest findByIdEager(Long id);

    List<RegistrationRequest> findByStudentId(Long studentId);
}

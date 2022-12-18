package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Course;
import courseRegistrationSystem.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}

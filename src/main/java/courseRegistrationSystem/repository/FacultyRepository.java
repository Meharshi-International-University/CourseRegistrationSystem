package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Course,Long> {
}

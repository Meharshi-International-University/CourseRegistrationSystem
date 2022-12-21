package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Course;
import courseRegistrationSystem.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    @Query("select r.courseOffering.course from Registration r where r.courseOffering.course.id=:courseId ")
   Course findCourseByCourseOfferingId(Long courseId);
}

package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Course;
import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    @Query("select r.courseOffering.course from Registration r where r.courseOffering.course.id=:courseId ")
   Course findCourseByCourseOfferingId(Long courseId);

    @Query("select r.courseOffering from Registration r  where r.student.id=:studentId ")
    List<CourseOffering> findCourseOfferingByStudent(Long studentId);

    @Query("select r.courseOffering from Registration r  where  r.courseOffering.id=:courseOfferingId and r.student.id=:studentId ")
    Optional<CourseOffering> findByCourseOfferingAndStudent(Long courseOfferingId, Long studentId);
}

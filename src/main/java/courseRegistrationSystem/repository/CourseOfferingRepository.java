package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering,Long> {
    CourseOffering findByCourseOfferingCode(String courseOfferingCode);

    List<CourseOffering> findByAcademicBlock_Id(Long id);
}

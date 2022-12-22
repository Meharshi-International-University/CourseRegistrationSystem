package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.AcademicBlock;
import courseRegistrationSystem.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering,Long> {
    Optional<CourseOffering> findByCourseOfferingCode(String courseOfferingCode);

    List<CourseOffering> findByAcademicBlock_Id(Long id);


    AcademicBlock findAcademicBlockById(Long id);
}

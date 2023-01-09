package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.*;
import courseRegistrationSystem.domain.pk.RegistrationRequestPK;
import courseRegistrationSystem.enums.RegistrationRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, RegistrationRequestPK> {

    List<RegistrationRequest> findByStudentId(Long studentId);

    @Query("select r from RegistrationRequest r where r.registrationEvent.id=:id and r.status=:status")
    List<RegistrationRequest> findRegistrationRequestByRegistrationEventIdAndStatus(Long id, RegistrationRequestStatus status);
    @Query("select r.courseOffering.course.prerequisite from RegistrationRequest r where r.courseOffering.id=:courseOfferingId ")
    List<Course> findPrequisiteByCourseOfferingId(Long courseOfferingId);

    Optional<RegistrationRequest> findByStudentAndCourseOfferingAndStatusNot(Student student, CourseOffering courseOffering, RegistrationRequestStatus status);

    @Query("select r from RegistrationRequest r  where r.student.id=:studentId and r.courseOffering.id=:courseOfferingId")
    RegistrationRequest findByIdEager(Long studentId,Long courseOfferingId);
}

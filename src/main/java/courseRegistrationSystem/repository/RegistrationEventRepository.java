package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Course;
import courseRegistrationSystem.domain.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent,Long> {

    @Query(value = "select * from registration_event where  id = \n" +
            "           ( select registration_event_id from registration_event_registration_groups\n" +
            "            where  registration_groups_registration_group_id = \n" +
            "            (select  registration_group_registration_group_id \n" +
            "            from registration_group_students where  students_id=:studentId))",nativeQuery = true)
    RegistrationEvent getStudentIdByRegistrationEvent(Long studentId);
}

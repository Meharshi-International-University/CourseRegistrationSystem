package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Course;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.dto.RegistrationEventDTO;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent,Long> {

//    @Query(value = "select * from registration_event where  id = \n" +
//            "           ( select registration_event_id from registration_event_registration_groups\n" +
//            "            where  registration_groups_registration_group_id = \n" +
//            "            (select  registration_group_registration_group_id \n" +
//            "            from registration_group_students where  students_id=:studentId))",nativeQuery = true)
    @Query(value = "select * from registration_event where  id =    \n" +
            " ( select registration_event_id from registration_event_registration_groups\n" +
            "                     inner join registration_event  on id = registration_event_id where  registration_groups_registration_group_id = \n" +
            "                     (select  registration_group_registration_group_id \n" +
            "                       from registration_group_students where  students_id= 1) ORDER BY end_date DESC limit 1) ;\n"
    ,nativeQuery = true)
    RegistrationEvent getStudentIdByRegistrationEvent(Long studentId);


    @Query("select r from RegistrationEvent r where r.startDate <:dateTime and r.endDate >:dateTime")
    List<RegistrationEvent>  getRegistrationByToday(LocalDateTime dateTime);


}

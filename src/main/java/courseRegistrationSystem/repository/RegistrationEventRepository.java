package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent,Long> {

    List<RegistrationEvent> findByRegistrationGroupsRegistrationGroupId(Long registrationGroupId);

//    @Query("select RegistrationEvent from RegistrationEvent r join RegistrationGroup g join Student s where s.studentId= :id")
//    RegistrationEvent getRegistrationEvent(@Param("id") String id );

//    @Query("select RegistrationEvent from RegistrationEvent r where r.registrationEventStatus= :status")
//    RegistrationEvent getRegistrationEvent(@Param("status") RegistrationEventStatus status);

    @Query(value= "select * from registration_event where  id="+
            "(select registration_event_id from registration_event_registration_groups where  registration_groups_registration_group_id = " +
            "(select  registration_group_registration_group_id from registration_group_students where  students_id=:studentId))", nativeQuery = true)
    List<RegistrationEvent> getRegistrationEventByStudentIds(Long studentId);

}

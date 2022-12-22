package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.AcademicBlock;
import courseRegistrationSystem.domain.RegistrationEvent;
import courseRegistrationSystem.domain.RegistrationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationGroupRepository extends JpaRepository<RegistrationGroup,Long> {


    @Query(value = "SELECT registration_event_id FROM course_registrationdb.registration_event_registration_groups where registration_groups_registration_group_id=:id",nativeQuery = true)
    List<Long> getRegistrationByGroupId(@Param("id")  Long id);



}

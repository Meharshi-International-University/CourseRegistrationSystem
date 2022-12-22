package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.AcademicBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicBlockRepository extends JpaRepository<AcademicBlock,Long> {

    @Query(value = "SELECT * FROM academicblock where registration_group_id = :registrationGroupId",nativeQuery = true )
   List<AcademicBlock> findByRegistrationGroupId(Long registrationGroupId);
}

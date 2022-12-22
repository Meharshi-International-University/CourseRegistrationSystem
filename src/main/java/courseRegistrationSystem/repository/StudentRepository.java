package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "SELECT registration_group_id FROM student where student_id =:id",nativeQuery = true)
    Long getRegistrationByStudentId(@Param("id")  Long id);

}

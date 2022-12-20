package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.RegistrationRequest;
import courseRegistrationSystem.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByStudentId(String studentId);


}

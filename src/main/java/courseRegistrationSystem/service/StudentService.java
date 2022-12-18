package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationDTO;
import courseRegistrationSystem.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();
    StudentDTO getStudentBy_Id(Long studentId);
    StudentDTO addNewStudent(Student student);
}

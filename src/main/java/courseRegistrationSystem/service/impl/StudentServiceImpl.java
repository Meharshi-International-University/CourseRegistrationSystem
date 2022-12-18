package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.repository.StudentRepository;
import courseRegistrationSystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StudentDTO> getAllStudents() {
       return studentRepository.findAll().stream().map(student ->
         modelMapper.map(student,StudentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentBy_Id(Long studentId) {
        var resultId=studentRepository.findById(studentId).get();
      return   modelMapper.map(resultId,StudentDTO.class);
    }

    @Override
    public StudentDTO addNewStudent(Student student) {
        return modelMapper.map(studentRepository.save(student),StudentDTO.class);
    }
}

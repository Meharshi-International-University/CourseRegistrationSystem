package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.Faculty;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.FacultyDTO;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.repository.FacultyRepository;
import courseRegistrationSystem.repository.StudentRepository;
import courseRegistrationSystem.service.FacultyService;
import courseRegistrationSystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FacultyDTO> getAllFaculties() {
        return facultyRepository.findAll().stream().map(faculty->
                modelMapper.map(faculty,FacultyDTO.class)).collect(Collectors.toList());
    }

    @Override
    public FacultyDTO getFacultyBy_Id(Long facultyId) {
        return modelMapper.map(facultyRepository.findById(facultyId),FacultyDTO.class);
    }

    @Override
    public FacultyDTO addNewFaculty(Faculty faculty) {
        var toSaveFaculty= facultyRepository.save(faculty);
        return modelMapper.map(toSaveFaculty,FacultyDTO.class);
    }
}

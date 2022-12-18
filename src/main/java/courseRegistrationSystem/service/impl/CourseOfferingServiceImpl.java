package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.dto.CourseOfferingDTO;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.repository.CourseOfferingRepository;
import courseRegistrationSystem.repository.StudentRepository;
import courseRegistrationSystem.service.CourseOfferingService;
import courseRegistrationSystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseOfferingServiceImpl implements CourseOfferingService {
    @Autowired
    private CourseOfferingRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseOfferingDTO> getAllCourseOfferings() {
        return repository.findAll().stream().map(courseOff ->
                modelMapper.map(courseOff, CourseOfferingDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CourseOfferingDTO getCourseOfferingBy_Id(Long courseOfferingId) {
        return modelMapper.map(repository.findById(courseOfferingId), CourseOfferingDTO.class);
    }

    @Override
    public CourseOfferingDTO addNewCourseOffering(CourseOffering courseOffering) {
        return modelMapper.map(repository.save(courseOffering),CourseOfferingDTO.class);
    }
}

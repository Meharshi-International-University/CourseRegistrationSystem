package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.Faculty;
import courseRegistrationSystem.dto.FacultyDTO;
import courseRegistrationSystem.dto.StudentDTO;

import java.util.List;

public interface FacultyService {

    List<FacultyDTO> getAllFaculties();
    FacultyDTO getFacultyBy_Id(Long facultyId);
    FacultyDTO addNewFaculty(Faculty faculty);
}

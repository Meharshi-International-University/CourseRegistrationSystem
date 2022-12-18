package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.CourseOffering;
import courseRegistrationSystem.dto.CourseOfferingDTO;
import courseRegistrationSystem.dto.StudentDTO;

import java.util.List;

public interface CourseOfferingService {

    List<CourseOfferingDTO> getAllCourseOfferings();
    CourseOfferingDTO getCourseOfferingBy_Id(Long courseId);
    CourseOfferingDTO addNewCourseOffering(CourseOffering courseOffering);
}

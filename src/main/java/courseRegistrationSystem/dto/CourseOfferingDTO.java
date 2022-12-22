package courseRegistrationSystem.dto;

import courseRegistrationSystem.domain.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CourseOfferingDTO {

    private String courseOfferingCode;
    private int capacity;
    private int availableSeats;
    private Course course;
//    private List<FacultyDTO> faculties=new ArrayList<>();
//    private List<RegistrationDTO> registrations= new ArrayList<>();
//    private List<RegistrationRequestDTO> registrationRequests= new ArrayList<>();
    private boolean selected = true;
    public CourseOfferingDTO() {
    }

    public CourseOfferingDTO(String courseOfferingCode, int capacity, int availableSeats) {
        this.courseOfferingCode = courseOfferingCode;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }
}

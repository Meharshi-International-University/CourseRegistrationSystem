package courseRegistrationSystem.domain;

import courseRegistrationSystem.domain.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CourseOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseOfferingCode;
    private int capacity;
    private int availableSeats;
    @OneToOne
    private Course course;
    @OneToMany
    private List<Faculty> faculties;
    @OneToMany
    private List<Registration> registrations;
    @OneToOne
    private AcademicBlock academicBlock;


    public CourseOffering() {
    }

    public CourseOffering(String courseOfferingCode, int capacity, int availableSeats, Course course, AcademicBlock academicBlock) {
        this.courseOfferingCode = courseOfferingCode;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.course = course;
        this.academicBlock = academicBlock;
    }
}

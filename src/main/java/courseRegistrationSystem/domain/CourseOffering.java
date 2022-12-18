package courseRegistrationSystem.domain;

import courseRegistrationSystem.domain.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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
    @JoinColumn(name = "courseOffering_id")
    @OrderColumn(name="sequence")
    private List<Faculty> faculties=new ArrayList<>();
    @OneToMany(mappedBy = "courseOffering")
    @OrderColumn(name="sequence")
    private List<Registration> registrations= new ArrayList<>();

    @OneToMany(mappedBy = "courseOffering")
    @OrderColumn(name="sequence")
    private List<RegistrationRequest> registrationRequests= new ArrayList<>();
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

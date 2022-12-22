package courseRegistrationSystem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import courseRegistrationSystem.domain.Course;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Column(unique=true)
    private String courseOfferingCode;
    private int capacity;
    private int availableSeats;
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    @OneToOne
    private Faculty faculty;
    @OneToMany(mappedBy = "courseOffering")
    @JsonManagedReference(value = "courseOffering")
    private List<Registration> registrations= new ArrayList<>();

    @OneToMany(mappedBy = "courseOffering")
    @JsonManagedReference(value = "courseOffering")
    private List<RegistrationRequest> registrationRequests= new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private AcademicBlock academicBlock;
    @Transient
    private String facultyInitials;


    public CourseOffering() {
    }

    public CourseOffering(String courseOfferingCode, int capacity, int availableSeats, Course course, AcademicBlock academicBlock) {
        this.courseOfferingCode = courseOfferingCode;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.course = course;
        this.academicBlock = academicBlock;
    }
    public CourseOffering(int capacity, int availableSeats, Course course, AcademicBlock academicBlock ,String facultyInitials) {
        this.courseOfferingCode = course.getCourseCode()+ "-"+academicBlock.getBlockCode() +"-"+facultyInitials;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.course = course;
        this.academicBlock = academicBlock;

    }
}

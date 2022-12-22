package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String courseCode;
    private String name;
    private String description;

    @OneToMany
    @OrderColumn(name="sequence")
    private List<Course>  prerequisite= new ArrayList<>();

    public Course(String courseCode, String name, String description) {
        this.courseCode = courseCode;
        this.name = name;
        this.description = description;

    }

    public Course() {

    }

    public void addCoursePrerequisite(Course course){
        prerequisite.add(course);
    }
}

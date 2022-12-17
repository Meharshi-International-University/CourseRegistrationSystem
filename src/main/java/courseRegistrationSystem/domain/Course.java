package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private String name;
    private String description;

    @OneToMany
    private List<Course>  prerequisite;

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

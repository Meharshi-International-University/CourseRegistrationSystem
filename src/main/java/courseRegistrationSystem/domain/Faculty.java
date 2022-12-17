package courseRegistrationSystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@Setter
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer facultyId;
    private String name;
    private String email;
    private String title;

    public Faculty(Integer facultyId, String name, String email, String title) {
        this.facultyId = facultyId;
        this.name = name;
        this.email = email;
        this.title = title;
    }
    public Faculty() {

    }
}


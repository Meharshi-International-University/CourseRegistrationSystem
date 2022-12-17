package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private String name;
    private String email;
    @OneToOne
    private Address mailAddress;
    @OneToOne
    private Address homeAddress;

    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.mailAddress = mailAddress;
        this.homeAddress = homeAddress;
    }

    public Student() {
    }

}

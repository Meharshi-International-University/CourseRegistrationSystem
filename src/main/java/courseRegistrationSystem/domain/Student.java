package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String studentId;
    private String name;
    private String email;
    @OneToOne
    private Address mailAddress;
    @OneToOne
    private Address homeAddress;

    public Student(String studentId, String name, String email, Address mailAddress, Address homeAddress) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.mailAddress = mailAddress;
        this.homeAddress = homeAddress;
    }

    public Student() {
    }

}

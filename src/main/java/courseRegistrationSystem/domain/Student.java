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
    private String studentId;
    private String name;
    private String email;
    @OneToOne(cascade =CascadeType.PERSIST)
    private Address mailAddress;
    @OneToOne(cascade =CascadeType.PERSIST)
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

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

    public Student(String studentId, String name, String email, Address mailAddress, Address homeAddress) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.mailAddress = mailAddress;
        this.homeAddress = homeAddress;
    }

    public Student() {
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "mailingStreet")),
            @AttributeOverride(name = "city", column = @Column(name = "mailingCity")),
            @AttributeOverride(name = "state", column = @Column(name = "mailingState")),
            @AttributeOverride(name = "countryRegion", column = @Column(name = "mailingCountryRegion")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailingPostalCode"))

    })
    private Address mailAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "homeStreet")),
            @AttributeOverride(name = "city", column = @Column(name = "homeCity")),
            @AttributeOverride(name = "state", column = @Column(name = "homeState")),
            @AttributeOverride(name = "countryRegion", column = @Column(name = "homeCountyRegion")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "homePostalCode"))
    })
    private Address homeAddress;



}

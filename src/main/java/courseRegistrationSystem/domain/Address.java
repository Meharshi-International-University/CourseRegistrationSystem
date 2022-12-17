package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String postalCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public Address(String street, City city, String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }
}

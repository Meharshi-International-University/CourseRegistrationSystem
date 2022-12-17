package courseRegistrationSystem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String countryRegion;
    private String postalCode;

    public Address() {
    }

    public Address(String street, String city, String state, String countryRegion, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.countryRegion = countryRegion;
        this.postalCode = postalCode;
    }
}

package courseRegistrationSystem.repository;

import courseRegistrationSystem.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}

package usm.api.doctoral_registration.repository.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.country.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}

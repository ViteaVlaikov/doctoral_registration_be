package usm.api.doctoral_registration.repository.supervisor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

    List<Supervisor> findAllByScienceSchoolId(Integer scienceSchoolId);

    @Query("from Supervisor where firstName = :firstName and lastName = :lastName")
    Optional<Supervisor> findByFirstNameAndLastName(String firstName, String lastName);
}
package usm.api.doctoral_registration.repository.supervisor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.util.Optional;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

    @Query("from Supervisor s " +
            "where concat(s.firstName ,' ', s.lastName) like '%:name%'")
    Optional<Supervisor> findByFullName(String name);
}
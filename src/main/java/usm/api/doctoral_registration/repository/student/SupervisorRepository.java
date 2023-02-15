package usm.api.doctoral_registration.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
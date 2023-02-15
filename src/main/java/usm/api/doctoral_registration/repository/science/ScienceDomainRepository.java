package usm.api.doctoral_registration.repository.science;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.science.ScienceDomain;

@Repository
public interface ScienceDomainRepository extends JpaRepository<ScienceDomain, Float> {
}
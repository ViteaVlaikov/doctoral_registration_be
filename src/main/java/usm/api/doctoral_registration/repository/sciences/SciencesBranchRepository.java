package usm.api.doctoral_registration.repository.sciences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.sciences.SciencesBranch;

@Repository
public interface SciencesBranchRepository extends JpaRepository<SciencesBranch, Float> {
}
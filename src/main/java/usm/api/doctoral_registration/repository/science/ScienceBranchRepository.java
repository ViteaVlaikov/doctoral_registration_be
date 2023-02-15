package usm.api.doctoral_registration.repository.science;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.science.ScienceBranch;

@Repository
public interface ScienceBranchRepository extends JpaRepository<ScienceBranch, Float> {
}
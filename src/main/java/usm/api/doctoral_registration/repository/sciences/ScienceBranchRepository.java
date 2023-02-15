package usm.api.doctoral_registration.repository.sciences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.sciences.ScienceBranch;

@Repository
public interface ScienceBranchRepository extends JpaRepository<ScienceBranch, Float> {
}
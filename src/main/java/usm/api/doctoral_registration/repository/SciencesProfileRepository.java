package usm.api.doctoral_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.sciences.SciencesProfile;

@Repository
public interface SciencesProfileRepository extends JpaRepository<SciencesProfile, Float> {
}
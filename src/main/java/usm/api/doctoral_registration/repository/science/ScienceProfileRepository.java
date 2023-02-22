package usm.api.doctoral_registration.repository.science;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.Collection;
import java.util.List;

@Repository
public interface ScienceProfileRepository extends JpaRepository<ScienceProfile, Float> {
    @Query("from ScienceProfile sp " +
            "join Speciality s2 on sp = s2.scienceProfile " +
            "join Student s on s2 = s.speciality " +
            "where sp.scienceBranch.id = :branch_id and s.study.yearStudy = :grade")
    List<ScienceProfile> findAllByScienceBranchIdAndYear(Integer branch_id, YearStudy grade);
}
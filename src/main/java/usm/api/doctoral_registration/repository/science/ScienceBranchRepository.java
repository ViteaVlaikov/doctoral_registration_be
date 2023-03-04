package usm.api.doctoral_registration.repository.science;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.science.ScienceBranch;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.Collection;
import java.util.List;

@Repository
public interface ScienceBranchRepository extends JpaRepository<ScienceBranch, Float> {
    @Query("from ScienceBranch sb " +
            "join ScienceDomain sd on sd = sb.scienceDomain " +
            "join ScienceProfile sp on sb = sp.scienceBranch " +
            "join Speciality s on sp = s.scienceProfile " +
            "join Student st on s = st.speciality " +
            "where sd.id = :domain_id and st.yearStudy = :grade")
    List<ScienceBranch> findAllByScienceDomainIdAndYear(Integer domain_id, YearStudy grade);
}
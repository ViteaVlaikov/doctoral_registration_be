package usm.api.doctoral_registration.repository.science;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;

@Repository
public interface ScienceDomainRepository extends JpaRepository<ScienceDomain, Float> {
    List<ScienceDomain> findAllByScienceSchoolId(Integer id);

    @Query("select count(s.id) from ScienceDomain sd " +
            "join ScienceBranch sb on sd = sb.scienceDomain " +
            "join ScienceProfile sp on sb = sp.scienceBranch " +
            "join Speciality s on sp = s.scienceProfile " +
            "join Student s2 on s = s2.speciality " +
            "where s2.yearStudy = :grade and sd.id = :id")
    Integer getCountOfStudentsByScienceDomainIdAndGrade(String grade, Integer id);

    @Query("from ScienceDomain sd " +
            "join ScienceSchool ss on ss = sd.scienceSchool " +
            "join ScienceBranch sb on sd = sb.scienceDomain " +
            "join ScienceProfile sp on sb = sp.scienceBranch " +
            "join Speciality s on sp = s.scienceProfile " +
            "join Student s2 on s = s2.speciality " +
            "where ss.id = :science_id and s2.yearStudy = :grade")
    List<ScienceDomain> findAllByScienceSchoolIdAndGrade(Integer science_id, YearStudy grade);
}
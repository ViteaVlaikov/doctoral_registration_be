package usm.api.doctoral_registration.repository.science;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

@Repository
public interface ScienceSchoolRepository extends JpaRepository<ScienceSchool, Long> {
    @Query("select count(s.id) from ScienceSchool ss " +
            "join ScienceDomain sd on ss = sd.scienceSchool " +
            "join ScienceBranch sb on sd = sb.scienceDomain " +
            "join ScienceProfile sp on sb = sp.scienceBranch " +
            "join Speciality s on sp = s.scienceProfile " +
            "join Student s2 on s = s2.study.speciality " +
            "where s2.study.yearStudy = :grade and ss.id = :id")
    Integer getCountOfStudentsByIdAndGrade(YearStudy grade, Integer id);
}
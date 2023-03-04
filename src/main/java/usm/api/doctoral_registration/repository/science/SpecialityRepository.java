package usm.api.doctoral_registration.repository.science;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.Collection;
import java.util.List;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Float> {
    @Query("from Speciality s " +
            "join Student st on s = st.speciality " +
            "where s.scienceProfile.id = :profile_id and st.yearStudy = :grade")
    List<Speciality> findAllByScienceProfileIdAndGrade(Integer profile_id, YearStudy grade);

    @Query("from Speciality s " +
            "where s.scienceProfile.scienceBranch.scienceDomain.scienceSchool.id = :id")
    List<Speciality> findAllByScienceSchool(Integer id);
}
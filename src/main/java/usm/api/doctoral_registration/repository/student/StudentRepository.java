package usm.api.doctoral_registration.repository.student;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    @Query("from Student " +
            "where speciality.id = :specialityId and yearStudy = :grade")
    List<Student> findAllBySpecialityIdAndGrade(Float specialityId, YearStudy grade);

//    @Query("from Student " +
//            "where speciality.scienceProfile.scienceBranch.scienceDomain.scienceSchool.id in (:schoolsId)")
//    List<Student> findAllBySchoolsIdContaining(List<Integer> schoolsId);
//
//    @Query("from Student " +
//            "where yearStudy in (:yearStudies)")
//    List<Student> findAllByYearStudyContaining(List<YearStudy> yearStudies);
//
//    @Query("from Student " +
//            "where speciality.id in (:specialitiesId)")
//    List<Student> findAllBySpecialityIdConstraining(List<Float> specialitiesId);

    static Specification<Student> byYearStudy(List<?> years) {
        return (student, cq, cb) -> student.get("year_study").in(years);
    }

    static Specification<Student> bySpecialitiesId(List<?> specialitiesId) {
        return (student, cq, cb) -> student.get("speciality").get("id").in(specialitiesId);
    }

    static Specification<Student> bySchoolsId(List<?> schoolsId) {
        return (student, cq, cb) ->
                student.get("speciality")
                        .get("scienceProfile")
                        .get("scienceBranch")
                        .get("scienceDomain")
                        .get("scienceSchool")
                        .get("id").in(schoolsId);
    }
}
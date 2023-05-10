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

    static Specification<Student> group(String name1, List<?> list1, String name2, String name3) {
        return (student, cq, cb) -> {
            cq.multiselect(
                    cb.concat(
                            student.get(name1),
                            cb.concat(" ", student.get(name2))
                    ),
                    student.get(name3),
                    cb.count(student.get("id"))
            );
            cq.where(student.get(name1).in(list1));
//            cq.groupBy(student.get(name1), student.get(name2), student.get(name3));
            return null;
        };
    }

    static Specification<Student> byYearStudy(List<?> years) {
        return (student, cq, cb) -> student.get("yearStudy").in(years);
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

    static Specification<Student> byDomainsId(List<?> domainsId) {
        return (student, cq, cb) ->
                student.get("speciality")
                        .get("scienceProfile")
                        .get("scienceBranch")
                        .get("scienceDomain")
                        .get("id").in(domainsId);
    }

    static Specification<Student> byBranchesId(List<?> branchesId) {
        return (student, cq, cb) ->
                student.get("speciality")
                        .get("scienceProfile")
                        .get("scienceBranch")
                        .get("id").in(branchesId);
    }

    static Specification<Student> byProfilesId(List<?> profilesId) {
        return (student, cq, cb) ->
                student.get("speciality")
                        .get("scienceProfile")
                        .get("id").in(profilesId);
    }

    static Specification<Student> bySpecialitiesId(List<?> specialitiesId) {
        return (student, cq, cb) ->
                student.get("speciality")
                        .get("id").in(specialitiesId);
    }

    static Specification<Student> byGender(List<?> genders) {
        return (student, cq, cb) ->
                student.get("gender")
                        .in(genders);
    }

    static Specification<Student> byStatus(List<?> status) {
        return (student, cq, cb) ->
                student.get("status")
                        .in(status);
    }

    static Specification<Student> byFinancing(List<?> financing) {
        return (student, cq, cb) ->
                student.get("financing")
                        .in(financing);
    }

    static Specification<Student> byRegistration(List<?> registration) {
        return (student, cq, cb) ->
                student.get("registration")
                        .in(registration);
    }

    static Specification<Student> byStudyType(List<?> studyType) {
        return (student, cq, cb) ->
                student.get("studyType")
                        .in(studyType);
    }

    static Specification<Student> byYearsBirth(List<?> years) {
        return (student, cq, cb) ->
                student.get("yearBirth")
                        .in(years);
    }

    static Specification<Student> byYearsBegin(List<?> years) {
        return (student, cq, cb) ->
                student.get("beginStudies")
                        .in(years);
    }

    static Specification<Student> byYearsEnd(List<?> years) {
        return (student, cq, cb) ->
                student.get("endStudies")
                        .in(years);
    }

    static Specification<Student> byFullNames(List<?> fullNames) {
        return (student, query, cb) ->
                fullNames.stream().map(
                        fullName ->
                                cb.like(
                                        cb.concat(
                                                cb.concat(
                                                        cb.concat(
                                                                cb.concat(
                                                                        student.get("lastName"), " "),
                                                                student.get("firstName")),
                                                        " "),
                                                student.get("patronymicName")),
                                        "%" + fullName + "%")
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byEmails(List<?> emails) {
        return (student, query, cb) ->
                emails.stream().map(
                        email ->
                                cb.like(
                                        cb.concat(
                                                cb.concat(
                                                        cb.concat(
                                                                student.get("corporateEmail"),
                                                                " "),
                                                        student.get("personalEmail")),
                                                ""),
                                        "%" + email + "%")
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byIdentNumber(List<?> numbers) {
        return (student, query, cb) ->
                numbers.stream().map(
                        number ->
                                cb.like(
                                        student.get("identNumber"),
                                        "%" + number + "%")
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byCitizenship(List<?> citizenship) {
        return (student, query, cb) ->
                citizenship.stream().map(
                        c ->
                                cb.like(
                                        student.get("identNumber"),
                                        "%" + c + "%")
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byDiplomas(List<?> diplomas) {
        return (student, query, cb) ->
                diplomas.stream().map(
                        diploma ->
                                cb.like(
                                        cb.concat(
                                                cb.concat(
                                                        cb.concat(
                                                                student.get("diplomaNumber"),
                                                                " "),
                                                        student.get("diplomaSeries")),
                                                ""),
                                        "%" + diploma + "%")
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byPhoneNumbers(List<?> numbers) {
        return (student, query, cb) ->
                numbers.stream().map(
                        number ->
                                cb.like(
                                        student.get("phoneNumber"),
                                        "%" + number + "%")
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> bySupervisors(List<?> supervisors) {
        return (student, cq, cb) ->
                student.get("supervisor")
                        .get("id")
                        .in(supervisors);
    }

    static Specification<Student> byCommittees(List<?> member_ids) {
        return (student, cq, cb) ->
                student.get("steeringCommittee")
                        .get("id")
                        .in(member_ids);

    }
}
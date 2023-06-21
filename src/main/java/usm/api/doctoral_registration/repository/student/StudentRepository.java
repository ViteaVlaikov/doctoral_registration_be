package usm.api.doctoral_registration.repository.student;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.List;

import static usm.api.doctoral_registration.util.string.StringUtils.*;

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
                    cb.count(student.get(ID))
            );
            cq.where(student.get(name1).in(list1));
//            cq.groupBy(student.get(name1), student.get(name2), student.get(name3));
            return null;
        };
    }

    static Specification<Student> byYearStudy(List<?> years) {
        return (student, cq, cb) -> student.get(YEAR_STUDY).in(years);
    }

    static Specification<Student> bySchoolsId(List<?> schoolsId) {
        return (student, cq, cb) ->
                student.get(SPECIALITY)
                        .get(SCIENCE_PROFILE)
                        .get(SCIENCE_BRANCH)
                        .get(SCIENCE_DOMAIN)
                        .get(SCIENCE_SCHOOL)
                        .get(ID).in(schoolsId);
    }

    static Specification<Student> byDomainsId(List<?> domainsId) {
        return (student, cq, cb) ->
                student.get(SPECIALITY)
                        .get(SCIENCE_PROFILE)
                        .get(SCIENCE_BRANCH)
                        .get(SCIENCE_DOMAIN)
                        .get(ID).in(domainsId);
    }

    static Specification<Student> byBranchesId(List<?> branchesId) {
        return (student, cq, cb) ->
                student.get(SPECIALITY)
                        .get(SCIENCE_PROFILE)
                        .get(SCIENCE_BRANCH)
                        .get(ID).in(branchesId);
    }

    static Specification<Student> byProfilesId(List<?> profilesId) {
        return (student, cq, cb) ->
                student.get(SPECIALITY)
                        .get(SCIENCE_PROFILE)
                        .get(ID).in(profilesId);
    }

    static Specification<Student> bySpecialitiesId(List<?> specialitiesId) {
        return (student, cq, cb) ->
                student.get(SPECIALITY)
                        .get(ID).in(specialitiesId);
    }

    static Specification<Student> byGender(List<?> genders) {
        return (student, cq, cb) ->
                student.get(GENDER)
                        .in(genders);
    }

    static Specification<Student> byStatus(List<?> status) {
        return (student, cq, cb) ->
                student.get(STATUS)
                        .in(status);
    }

    static Specification<Student> byFinancing(List<?> financing) {
        return (student, cq, cb) ->
                student.get(FINANCING)
                        .in(financing);
    }

    static Specification<Student> byRegistration(List<?> registration) {
        return (student, cq, cb) ->
                student.get(REGISTRATION)
                        .in(registration);
    }

    static Specification<Student> byStudyType(List<?> studyType) {
        return (student, cq, cb) ->
                student.get(STYDY_TYPE)
                        .in(studyType);
    }

    static Specification<Student> byYearsBirth(List<?> years) {
        return (student, cq, cb) ->
                student.get(YEAR_BIRTH)
                        .in(years);
    }

    static Specification<Student> byYearsBegin(List<?> years) {
        return (student, cq, cb) ->
                student.get(BEGIN_STUDIES)
                        .in(years);
    }

    static Specification<Student> byYearsEnd(List<?> years) {
        return (student, cq, cb) ->
                student.get(END_STUDIES)
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
                                                                        student.get(LAST_NAME), SPACE),
                                                                student.get(FIRST_NAME)),
                                                        SPACE),
                                                student.get(PATRONYMIC_NAME)),
                                        PROCENT + fullName + PROCENT)
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
                                                                student.get(CORPORATE_EMAIL),
                                                                SPACE),
                                                        student.get(PERSONAL_EMAIL)),
                                                SPACE),
                                        PROCENT + email + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byIdentNumber(List<?> numbers) {
        return (student, query, cb) ->
                numbers.stream().map(
                        number ->
                                cb.like(
                                        student.get(IDENT_NUMBER),
                                        PROCENT + number + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byCitizenship(List<?> citizenship) {
        return (student, query, cb) ->
                citizenship.stream().map(
                        c ->
                                cb.like(
                                        student.get(IDENT_NUMBER),
                                        PROCENT + c + PROCENT)
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
                                                                student.get(DIPLOMA_NUMBER),
                                                                SPACE),
                                                        student.get(DIPLOMA_SERIES)),
                                                SPACE),
                                        PROCENT + diploma + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byPhoneNumbers(List<?> numbers) {
        return (student, query, cb) ->
                numbers.stream().map(
                        number ->
                                cb.like(
                                        student.get(PHONE_NUMBER),
                                        PROCENT + number + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> bySupervisors(List<?> supervisors) {
        return (student, cq, cb) ->
                student.get(SUPERVISOR)
                        .get(ID)
                        .in(supervisors);
    }

    static Specification<Student> byCommittees(List<?> memberIds) {
        return (student, cq, cb) ->
                student.get(STEERING_COMMITTEE)
                        .get(ID)
                        .in(memberIds);

    }
}
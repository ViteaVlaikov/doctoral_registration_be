package usm.api.doctoral_registration.repository.student;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.util.string.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static usm.api.doctoral_registration.util.string.StringUtils.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    @Query("from Student " +
            "where speciality.id = :specialityId and yearStudy = :grade")
    List<Student> findAllBySpecialityIdAndGrade(Float specialityId, YearStudy grade);

    static Specification<Student> byFieldValues(Map<String, String> fieldValues) {
        return (student, cq, cb) -> {
            Predicate[] predicates = fieldValues.entrySet().stream()
                    .map(entry -> {
                        String fieldName = entry.getKey();
                        String value = entry.getValue();
                        Path<String> fieldPath = getFieldPathForFieldName(student, fieldName);
                        return cb.equal(fieldPath, value);
                    })
                    .toArray(Predicate[]::new);

            return cb.and(predicates);
        };
    }

    private static Path<String> getFieldPathForFieldName(Root<Student> student, String fieldName) {
        return switch (fieldName) {
            case ClassField.STATUS -> student.get(ClassField.STATUS);
            case ClassField.FINANCING -> student.get(ClassField.FINANCING);
            case ClassField.GENDER -> student.get(ClassField.GENDER);
            // Добавьте дополнительные поля при необходимости
            default -> throw new IllegalArgumentException("Invalid field name: " + fieldName);
        };
    }

    static Specification<Student> byYearStudy(List<?> years) {
        return (student, cq, cb) -> student.get(ClassField.YEAR_STUDY).in(years);
    }

    static Specification<Student> bySchoolsId(List<?> schoolsId) {
        return (student, cq, cb) ->
                student.get(ClassField.SPECIALITY)
                        .get(ClassField.SCIENCE_PROFILE)
                        .get(ClassField.SCIENCE_BRANCH)
                        .get(ClassField.SCIENCE_DOMAIN)
                        .get(ClassField.SCIENCE_SCHOOL)
                        .get(ClassField.ID).in(schoolsId);
    }

    static Specification<Student> byDomainsId(List<?> domainsId) {
        return (student, cq, cb) ->
                student.get(ClassField.SPECIALITY)
                        .get(ClassField.SCIENCE_PROFILE)
                        .get(ClassField.SCIENCE_BRANCH)
                        .get(ClassField.SCIENCE_DOMAIN)
                        .get(ClassField.ID).in(domainsId);
    }

    static Specification<Student> byBranchesId(List<?> branchesId) {
        return (student, cq, cb) ->
                student.get(ClassField.SPECIALITY)
                        .get(ClassField.SCIENCE_PROFILE)
                        .get(ClassField.SCIENCE_BRANCH)
                        .get(ClassField.ID).in(branchesId);
    }

    static Specification<Student> byProfilesId(List<?> profilesId) {
        return (student, cq, cb) ->
                student.get(ClassField.SPECIALITY)
                        .get(ClassField.SCIENCE_PROFILE)
                        .get(ClassField.ID).in(profilesId);
    }

    static Specification<Student> bySpecialitiesId(List<?> specialitiesId) {
        return (student, cq, cb) ->
                student.get(ClassField.SPECIALITY)
                        .get(ClassField.ID).in(specialitiesId);
    }

    static Specification<Student> byGender(List<?> genders) {
        return (student, cq, cb) ->
                student.get(ClassField.GENDER)
                        .in(genders);
    }

    static Specification<Student> byStatus(List<?> status) {
        return (student, cq, cb) ->
                student.get(ClassField.STATUS)
                        .in(status);
    }

    static Specification<Student> byFinancing(List<?> financing) {
        return (student, cq, cb) ->
                student.get(ClassField.FINANCING)
                        .in(financing);
    }

    static Specification<Student> byRegistration(List<?> registration) {
        return (student, cq, cb) ->
                student.get(ClassField.REGISTRATION)
                        .in(registration);
    }

    static Specification<Student> byStudyType(List<?> studyType) {
        return (student, cq, cb) ->
                student.get(ClassField.STYDY_TYPE)
                        .in(studyType);
    }

    static Specification<Student> byYearsBirth(List<?> years) {
        return (student, cq, cb) ->
                student.get(ClassField.YEAR_BIRTH)
                        .in(years);
    }

    static Specification<Student> byYearsBegin(List<?> years) {
        return (student, cq, cb) ->
                student.get(ClassField.BEGIN_STUDIES)
                        .in(years);
    }

    static Specification<Student> byYearsEnd(List<?> years) {
        return (student, cq, cb) ->
                student.get(ClassField.END_STUDIES)
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
                                                                        student.get(ClassField.LAST_NAME), SPACE),
                                                                student.get(ClassField.FIRST_NAME)),
                                                        SPACE),
                                                student.get(ClassField.PATRONYMIC_NAME)),
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
                                                                student.get(ClassField.CORPORATE_EMAIL),
                                                                SPACE),
                                                        student.get(ClassField.PERSONAL_EMAIL)),
                                                SPACE),
                                        PROCENT + email + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byIdentNumber(List<?> numbers) {
        return (student, query, cb) ->
                numbers.stream().map(
                        number ->
                                cb.like(
                                        student.get(ClassField.IDENT_NUMBER),
                                        PROCENT + number + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byCitizenship(List<?> citizenship) {
        return (student, query, cb) ->
                citizenship.stream().map(
                        c ->
                                cb.like(
                                        student.get(ClassField.CITIZENSHIP)
                                                .get(NAME),
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
                                                        student.get(ClassField.DIPLOMA_SERIES),
                                                        SPACE),
                                                student.get(ClassField.DIPLOMA_NUMBER)),
                                        PROCENT + diploma + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> byPhoneNumbers(List<?> numbers) {
        return (student, query, cb) ->
                numbers.stream().map(
                        number ->
                                cb.like(
                                        student.get(ClassField.PHONE_NUMBER),
                                        PROCENT + number + PROCENT)
                ).reduce(cb.or(), cb::or);
    }

    static Specification<Student> bySupervisors(List<?> supervisors) {
        return (student, cq, cb) ->
                student.get(ClassField.SUPERVISOR)
                        .get(ClassField.ID)
                        .in(supervisors);
    }

    static Specification<Student> byCommittees(List<?> memberIds) {
        return (student, cq, cb) ->
                student.get(ClassField.STEERING_COMMITTEE)
                        .get(ClassField.ID)
                        .in(memberIds);

    }
}
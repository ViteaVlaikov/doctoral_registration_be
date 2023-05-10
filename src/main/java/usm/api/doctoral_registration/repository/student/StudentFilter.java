package usm.api.doctoral_registration.repository.student;

import org.springframework.data.jpa.domain.Specification;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public enum StudentFilter {

    SPECIALITY_ID("speciality_id", StudentRepository::bySpecialitiesId, Float::valueOf),

    PROFILE_ID("profile_id", StudentRepository::byProfilesId, Integer::valueOf),

    BRANCH_ID("branch_id", StudentRepository::byBranchesId, Integer::valueOf),

    DOMAIN_ID("domain_id", StudentRepository::byDomainsId, Integer::valueOf),

    SCHOOL_ID("school_id", StudentRepository::bySchoolsId, Integer::valueOf),

    GENDER("gender", StudentRepository::byGender, Gender::toGender),

    STATUS("status", StudentRepository::byStatus, Status::toStatus),

    FINANCING("financing", StudentRepository::byFinancing, Financing::toFinancing),

    REGISTRATION("registration", StudentRepository::byRegistration, Registration::toRegistration),

    STUDY_TYPE("study_type", StudentRepository::byStudyType, StudyType::toStudyType),

    YEAR("year_study", StudentRepository::byYearStudy, YearStudy::toYearStudy),

    YEAR_BIRTH("year_birth", StudentRepository::byYearsBirth, Integer::valueOf),

    YEAR_BEGIN("year_begin", StudentRepository::byYearsBegin, LocalDate::parse),

    YEAR_END("year_end", StudentRepository::byYearsEnd, LocalDate::parse),

    FULL_NAME("full_name", StudentRepository::byFullNames, a -> a),

    EMAIL("email", StudentRepository::byEmails, a -> a),

    IDENT_NUMBER("ident_number", StudentRepository::byIdentNumber, a -> a),

    CITIZENSHIP("citizenship", StudentRepository::byCitizenship, a -> a),

    DIPLOMA("diploma", StudentRepository::byDiplomas, a -> a),

    TELEPHONE_NUMBER("telephone_number", StudentRepository::byPhoneNumbers, a -> a),

    SUPERVISOR("supervisor_id", StudentRepository::bySupervisors, Integer::valueOf),

    STEERING_COMMITTEE("committee_member_id", StudentRepository::byCommittees, Integer::valueOf);

    final String field;

    final Function<List<?>, Specification<Student>> function;

    final Function<String, ?> toType;

    StudentFilter(String field, Function<List<?>, Specification<Student>> function, Function<String, ?> toType) {
        this.field = field;
        this.function = function;
        this.toType = toType;
    }

    public static Specification<Student> convertMapToJpaSpecification(Map<String, String> params) {
        return params.entrySet().stream()
                .map(entry -> getSpecification(entry.getKey(), entry.getValue()))
                .reduce(Specification.where(null), Specification::and);
    }

    public static Specification<Student> getSpecification(String key, String value) {
        StudentFilter field = findByField(key);
        List<?> values = Arrays.stream(value.split(",")).map(field.toType).toList();
        return field.function.apply(values);
    }

    public static StudentFilter findByField(String value) {
        return Arrays.stream(StudentFilter.values())
                .filter(field -> field.field.equals(value))
                .findFirst().orElseThrow();
    }

    public String getField() {
        return this.field;
    }
}

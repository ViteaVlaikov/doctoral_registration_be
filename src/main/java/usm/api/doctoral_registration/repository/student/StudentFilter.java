package usm.api.doctoral_registration.repository.student;

import org.springframework.data.jpa.domain.Specification;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public enum StudentFilter {

    SPECIALITY_ID("speciality_id", StudentRepository::bySpecialitiesId, Float::valueOf),

    SCHOOL_ID("school_id", StudentRepository::bySchoolsId, Integer::valueOf),

    YEAR("year_study", StudentRepository::byYearStudy, YearStudy::toYear);

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

}

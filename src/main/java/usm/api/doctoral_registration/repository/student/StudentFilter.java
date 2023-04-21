package usm.api.doctoral_registration.repository.student;

import org.springframework.data.jpa.domain.Specification;
import usm.api.doctoral_registration.mapper.YearStudyMapperImpl;
import usm.api.doctoral_registration.model.student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public enum StudentFilter {

    SPECIALITY_ID("speciality_id", StudentRepository::bySpecialitiesId, Float::parseFloat),

    SCHOOL_ID("school_id", StudentRepository::bySchoolsId, Integer::parseInt),

    YEAR("year_study", StudentRepository::byYearStudy, YearStudyMapperImpl::mapFromInteger);

    final String field;

    final Function<List<?>, Specification<Student>> function;

    StudentFilter(String field, Function<List<?>, Specification<Student>> function, Function<?, ?> ) {
        this.field = field;
        this.function = function;
    }

    public static Specification<Student> convertMapToJpaSpecification(Map<String, String> params) {

//        params.entrySet().stream().map(entry -> );
        params.entrySet().stream()
                .map(entry -> toSpecification(entry.getKey(), entry.getValue().))
                .


//        StudentFilter.SCHOOL_ID.function.apply()
    }

    public static Specification<Student> toSpecification(String key, List<?> values)
    public static StudentFilter findByField(String value) {
        return Arrays.stream(StudentFilter.values())
                .filter(field -> field.field.equals(value))
                .findFirst().orElseThrow();
    }

}

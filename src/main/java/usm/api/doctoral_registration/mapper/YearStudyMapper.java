package usm.api.doctoral_registration.mapper;

import usm.api.doctoral_registration.model.student.properties.YearStudy;

public interface YearStudyMapper {
    YearStudy mapFromInteger(Integer year);

    Integer mapToInteger(YearStudy year);

    YearStudy mapFromString(String grade);

    String mapToString(YearStudy grade);
}

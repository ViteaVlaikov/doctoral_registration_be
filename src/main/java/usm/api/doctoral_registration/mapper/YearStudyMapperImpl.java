package usm.api.doctoral_registration.mapper;

import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

@Component
public class YearStudyMapperImpl implements YearStudyMapper {

    @Override
    public YearStudy mapFromInteger(Integer year) {
        return YearStudy.toYearStudy(year);
    }

    @Override
    public Integer mapToInteger(YearStudy year) {
        return null;
    }

    @Override
    public YearStudy mapFromString(String grade) {
        return YearStudy.toYearStudy(grade);
    }

    @Override
    public String mapToString(YearStudy grade) {
        return null;
    }
}

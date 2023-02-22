package usm.api.doctoral_registration.mapper;

import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.model.student.properties.YearStudy;

@Component
public class YearStudyMapperImpl implements YearStudyMapper {

    @Override
    public YearStudy mapFromInteger(Integer year) {
        if(year == 1)
            return YearStudy.I;
        if(year == 2)
            return YearStudy.II;
        if(year == 3)
            return YearStudy.III;
        if(year == 4)
            return YearStudy.IV;
        if(year == 5)
            return YearStudy.EXTRA_I;
        if(year == 6)
            return YearStudy.EXTRA_II;
        return null;
    }

    @Override
    public Integer mapToInteger(YearStudy year) {
        return null;
    }

    @Override
    public YearStudy mapFromString(String grade) {
        return null;
    }

    @Override
    public String mapToString(YearStudy grade) {
        return null;
    }
}

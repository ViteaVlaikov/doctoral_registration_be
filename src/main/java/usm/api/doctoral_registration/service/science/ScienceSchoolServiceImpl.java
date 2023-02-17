package usm.api.doctoral_registration.service.science;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.mapper.science.ScienceSchoolMapper;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.dto.science.ScienceSchoolDto;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceSchoolRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScienceSchoolServiceImpl implements ScienceSchoolService {
    private final ScienceSchoolRepository scienceSchoolRepository;
    private final ScienceSchoolMapper scienceSchoolMapper;
    @Override
    public List<ScienceSchool> findAll() {
        return scienceSchoolRepository.findAll();
    }

    @Override
    public Map<ScienceSchoolDto, List<Integer>> getScienceSchoolByYears() {
        List<ScienceSchool> scienceSchools = scienceSchoolRepository.findAll();
        Map<ScienceSchoolDto, List<Integer>> result = new HashMap<>();
        for(ScienceSchool scienceSchool : scienceSchools) {
            ScienceSchoolDto scienceSchoolDto = scienceSchoolMapper.toDto(scienceSchool);
            result.put(scienceSchoolDto,getCountOfStudentsByYearsForScienceSchool(scienceSchool));
        }
        return result;
    }

    private List<Integer> getCountOfStudentsByYearsForScienceSchool(ScienceSchool scienceSchool) {
        List<Integer> studentsCount = new ArrayList<>();
        studentsCount.add(scienceSchoolRepository.getCountOfStudentsByIdAndGrade(YearStudy.I,scienceSchool.getId()));
        studentsCount.add(scienceSchoolRepository.getCountOfStudentsByIdAndGrade(YearStudy.II,scienceSchool.getId()));
        studentsCount.add(scienceSchoolRepository.getCountOfStudentsByIdAndGrade(YearStudy.III,scienceSchool.getId()));
        studentsCount.add(scienceSchoolRepository.getCountOfStudentsByIdAndGrade(YearStudy.IV,scienceSchool.getId()));
        studentsCount.add(scienceSchoolRepository.getCountOfStudentsByIdAndGrade(YearStudy.EXTRA_I,scienceSchool.getId()));
        studentsCount.add(scienceSchoolRepository.getCountOfStudentsByIdAndGrade(YearStudy.EXTRA_II,scienceSchool.getId()));
        return studentsCount;
    }
}
